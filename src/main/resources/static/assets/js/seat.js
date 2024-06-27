window.onload = function() {
    var seatImages = document.getElementsByClassName('seat-img');
    for (var i = 0; i < seatImages.length; i++) {
        // Lưu src gốc vào data-src-original và thiết lập trạng thái ban đầu là không được chọn
        seatImages[i].setAttribute('data-src-original', seatImages[i].src);
        seatImages[i].setAttribute('data-selected', 'false');

        seatImages[i].addEventListener('mouseover', function() {
            this.src = this.getAttribute('data-src2');
            console.log("tôi là sự kiện on over ");
        });

        seatImages[i].addEventListener('mouseout', function() {
            if (this.getAttribute('data-selected') === 'false') {
                this.src = this.getAttribute('data-src-original');
            }
            console.log("tôi là sự kiện on mouse out ");
        });

        seatImages[i].addEventListener('dblclick', function() {
            if (this.getAttribute('data-selected') === 'false') {
                // Nếu hình ảnh không được chọn, đặt nó thành được chọn và cập nhật src
                this.setAttribute('data-selected', 'true');
                this.src = this.getAttribute('data-src2');
            } else {
                // Nếu hình ảnh đã được chọn, đặt nó thành không được chọn và khôi phục src gốc
                this.setAttribute('data-selected', 'false');
                this.src = this.getAttribute('data-src-original');
            }
            this.removeEventListener('mouseout', arguments.callee);
            console.log("tôi là sự kiện on double click ");
        });
    }
}
