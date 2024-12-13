package com.example.movietickets.demo.controller.ApiController.admin;


import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.model.Country;
import com.example.movietickets.demo.model.Film;
import com.example.movietickets.demo.model.Seat;
import com.example.movietickets.demo.service.APIService.AdminApiService;
import com.example.movietickets.demo.service.CountryService;
import com.example.movietickets.demo.service.SeatService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/admin")
public class AdminFilmAPIController {
    private final CountryService countryService;
    private final AdminApiService adminApiService;
    private final SeatService seatService;

    public AdminFilmAPIController(CountryService countryService, AdminApiService adminApiService, SeatService seatService){
        this.countryService = countryService;
        this.adminApiService= adminApiService;
        this.seatService = seatService;
    }
//
//    @GetMapping("/schedule/{scheduleId}")
//    public ResponseEntity<Object> getSeatsBySchedule(@PathVariable Long scheduleId) {
//        Object seats = seatService.getSeatsByScheduleId(scheduleId);
//        return ResponseEntity.ok(seats);
//    }
    @GetMapping("/films")
    public List<Film> getAllFilms(){
        return adminApiService.getAllFilm();
    }

    @GetMapping("/films/{id}")
    public Optional<Film> getFilmById(@PathVariable Long id){
        return adminApiService.getFilmById(id);
    }


    @PostMapping("/films")
    public ResponseEntity<?> createFilm(
            @RequestParam("name") String name,
            @RequestParam("trailer") String trailer,
            @RequestParam("description") String description,
            @RequestParam("director") String director,
            @RequestParam("actor") String actor,
            @RequestParam("openingday") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date openingday,
            @RequestParam("subtitle") String subtitle,
            @RequestParam("duration") Integer duration,
            @RequestParam("limit_age") String limit_age,
            @RequestParam("quanlity") String quanlity,
            @RequestParam("countryId") Long countryId,
            @RequestParam("categoryIds") List<Long> categoryIds,
            @RequestParam(value = "poster", required = false) MultipartFile poster,
            @RequestParam(value = "imageURL", required = false) String imageURL
    ) throws IOException {
        if (name == null || trailer == null || description == null || director == null ||
                actor == null || openingday == null || subtitle == null || duration == null ||
                limit_age == null || quanlity == null || countryId == null || categoryIds == null || categoryIds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("All fields are required and at least one category ID.");
        }

        try {
            Film film = new Film();
            film.setName(name);
            film.setTrailer(trailer);
            film.setDescription(description);
            film.setDuration(duration);
            film.setDirector(director);
            film.setActor(actor);
            film.setOpeningday(openingday);
            film.setQuanlity(quanlity);
            film.setSubtitle(subtitle);
            film.setLimit_age(limit_age);

            Country country = countryService.getCountryById(countryId).orElse(null);
            if (country == null) {
                return ResponseEntity.badRequest().body("Country ID không hợp lệ.");
            }
            film.setCountry(country);

            if ((poster == null || poster.isEmpty()) && (imageURL == null || imageURL.isEmpty())) {
                return ResponseEntity.badRequest().body("Cần cung cấp một tệp ảnh hoặc URL ảnh.");
            }
            String imgName = saveImageStatic(poster);
            if (imgName !=null)
                film.setPoster("/assets/img/movie/" + imgName);
            else
                film.setPoster(imageURL);
            List<Category> attachedCategories = adminApiService.getCategoriesByIds(categoryIds);
            if (attachedCategories.size() != categoryIds.size()) {
                return ResponseEntity.badRequest().body("Có một hoặc nhiều Category ID không hợp lệ.");
            }

            film.setCategories(attachedCategories);

            adminApiService.addFilm(film);
            return ResponseEntity.ok(film);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi dữ liệu: " + e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Trạng thái không hợp lệ: " + e.getMessage());
        }
    }


    @PutMapping("/films/{id}")
    public ResponseEntity<?> updateFilm(@PathVariable Long id,
                                        @RequestParam(value = "image",required = false) MultipartFile image,
                                        @RequestParam(value = "imageURL",required = false) String imageURL)
    {
        try{

            Optional<Film> existingFilm = adminApiService.getFilmById(id);

            if (existingFilm.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy phim với id: " +id);
            }

            if(image != null && !image.isEmpty()){
                String poster = saveImageStatic(image);
                existingFilm.get().setPoster(poster);
            }
            else if (imageURL != null && !imageURL.isEmpty()){
                existingFilm.get().setPoster(imageURL);
            }
            else {
                return ResponseEntity.badRequest().body("Cần cung cấp một tệp ảnh hoặc URL ảnh.");
            }
            adminApiService.addFilm(existingFilm.get());
            return ResponseEntity.ok(Collections.singletonMap("message", "Chỉnh sửa thông tin phim với id: " + id + " thành công"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @DeleteMapping("/films/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable Long id){
        adminApiService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }

    private String saveImageStatic(MultipartFile image) throws IOException {
        Path dirImages = Paths.get("target/classes/static/assets/img/movie");
        if (!Files.exists(dirImages)) {
            Files.createDirectories(dirImages);
        }

        String newFileName = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(image.getOriginalFilename());

        Path pathFileUpload = dirImages.resolve(newFileName);
        Files.copy(image.getInputStream(), pathFileUpload,
                StandardCopyOption.REPLACE_EXISTING);
        return newFileName;
    }
}
