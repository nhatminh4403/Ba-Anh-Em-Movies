package com.example.movietickets.demo.service.APIService;

import com.example.movietickets.demo.model.Booking;
import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.model.Country;
import com.example.movietickets.demo.model.Film;
import com.example.movietickets.demo.repository.BookingRepository;
import com.example.movietickets.demo.repository.CategoryRepository;
import com.example.movietickets.demo.repository.CountryRepository;
import com.example.movietickets.demo.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdminApiService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public List<Category> getAllCategory() {
        return  categoryRepository.findAll();
    }
    public Optional<Category> getCategoryById(Long id){
        return  categoryRepository.findById(id);
    }
    public List<Category> getCategoriesByIds(List<Long> Ids) {
        return categoryRepository.findAllById(Ids);
    }
    public List<Film> getAllFilm() {
        return  filmRepository.findAll();
    }
    public Optional<Film> getFilmById(Long id){
        return  filmRepository.findById(id);
    }

    public List<Country> getAllCountry() {return  countryRepository.findAll();}
    //Country
    public Optional<Country> getCountryById(Long id){
        return  countryRepository.findById(id);
    }
    //Category
    @Transactional
    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    @Transactional
    public Category updateCategory(Category category){
        return categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(Long id){

        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy thể loại thuộc id: "+ id));

        categoryRepository.delete(category);
    }
    public boolean categoryNameExists(String name, Long id) {
        // Assuming you have a repository with a method to find by name
        Optional<Category> category = categoryRepository.findCategoriesByNameContainingIgnoreCase(name);
        return category.isPresent() && !category.get().getId().equals(id);
    }
    //Film
    @Transactional
    public void addFilm(Film film){
        filmRepository.save(film);
    }

    @Transactional
    public Film updateFilm(Film film){
        return filmRepository.save(film);
    }

    @Transactional
    public void deleteFilm(Long id){

        Film filmToBeDeleted = filmRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy phim có id: "+ id));

        filmRepository.delete(filmToBeDeleted);

    }

//    Booking

    @Transactional
    public Optional<Booking> getBookingId(Long id) {
        return bookingRepository.findById(id);
    }
    @Transactional
    public Booking getBookingById(Long id){
        return bookingRepository.findById(id).get();
    }
}
