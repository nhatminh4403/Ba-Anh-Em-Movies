document.addEventListener('DOMContentLoaded', function() {
    const imageInput = document.getElementById('imageInput');
    const imagePreview = document.getElementById('imagePreview');
    const scanButton = document.getElementById('scanButton');
    const loadingIndicator = document.getElementById('loadingIndicator');

    // Preview ảnh
    imageInput.addEventListener('change', function(e) {
        const file = e.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(e) {
                imagePreview.style.display = 'block';
                imagePreview.src = e.target.result;
                scanButton.disabled = false;
            }
            reader.readAsDataURL(file);
        }
    });

    // Xử lý quét thẻ
    scanButton.addEventListener('click', async function() {
        const file = imageInput.files[0];
        if (!file) return;

        loadingIndicator.style.display = 'block';
        scanButton.disabled = true;

        const formData = new FormData();
        formData.append('image', file);

        try {
            const response = await fetch('/api/ocr/scan', {
                method: 'POST',
                body: formData
            });

            const data = await response.json();
            if (response.ok) {
                // Điền thông tin vào các trường
                // document.getElementById('studentId').value = data.studentId || '';
                document.getElementById('fullname').value = data.fullName || '';
                document.getElementById('birthday').value = data.birthday || '';
                // document.getElementById('class').value = data.class || '';
                // document.getElementById('major').value = data.major || '';
                // document.getElementById('nienKhoa').value = data.nienKhoa || '';
                // document.getElementById('fullText').value = data.fullText || '';
                document.getElementById('age').value = data.age || '';
            } else {
                alert('Có lỗi xảy ra: ' + data.error);
            }
        } catch (error) {
            alert('Có lỗi xảy ra khi xử lý yêu cầu');
        } finally {
            loadingIndicator.style.display = 'none';
            scanButton.disabled = false;
        }
    });
});