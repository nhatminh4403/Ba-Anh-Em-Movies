function rate(star) {
            var i;
            for (i = 1; i <= 5; i++) {
                var starElement = document.getElementById('star' + i);
                if (i <= star) {
                    starElement.classList.add('selected');
                } else {
                    starElement.classList.remove('selected');
                }
            }
            document.getElementById('rating').value = star;
}

        function validateForm() {
            var rating = document.getElementById('rating').value;
            var content = document.getElementsByName('content')[0].value;

            if (!rating) {
                alert("Vui lòng chọn số sao để đánh giá.");
                return false;
            }

            if (!content.trim()) {
                alert("Vui lòng nhập nội dung đánh giá.");
                return false;
            }

            return true;
        }