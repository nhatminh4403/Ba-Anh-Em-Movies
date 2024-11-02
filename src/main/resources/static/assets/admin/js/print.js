$(document).ready(function() {
        $('.main__table-btn--edit').on('click', function() {
            // Lấy bookingId từ data attribute
            var bookingId = $(this).data('booking-id');

            // Gửi yêu cầu AJAX tới API
            $.ajax({
                url: '/api/admin/ticket/generate-pdfs/' + bookingId,
                type: 'GET',
                dataType: 'json',
                success: function(response) {
                    // Xử lý phản hồi và tạo các file PDF
                    response.forEach(function(pdfBase64, index) {
                        var link = document.createElement('a');
                        link.href = 'data:application/pdf;base64,' + pdfBase64;
                        link.download = 'ticket_' + bookingId + '_' + index + '.pdf';
                        document.body.appendChild(link);
                        link.click();
                        document.body.removeChild(link);
                    });
                },
                error: function(xhr, status, error) {
                    console.error('Error generating PDFs:', error);
                    alert('Có lỗi xảy ra khi tạo PDF. Vui lòng thử lại.');
                }
            });
        });
    });