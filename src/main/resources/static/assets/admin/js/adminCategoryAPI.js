document.addEventListener('DOMContentLoaded', function () {

    fetch('http://localhost:8080/api/admin/categories')
        .then(response => response.json())
        .then(data => {
            const tbody = document.getElementById('category_body');

            data.forEach(category => {
                const row = document.createElement('tr');
                row.setAttribute('data-category-id', category.id);
                // Tạo cột ID
                const idTd = document.createElement('td');
                const idDiv = document.createElement('div');
                idDiv.className = 'main__table-text';
                idDiv.textContent = category.id;
                idTd.appendChild(idDiv);
                row.appendChild(idTd);


                // Tạo cột Tên
                const nameTd = document.createElement('td');
                const nameDiv = document.createElement('div');
                nameDiv.className = 'main__table-text';
                nameDiv.textContent = category.name;
                nameTd.appendChild(nameDiv);
                row.appendChild(nameTd);


                // Tạo cột nút chỉnh sửa và xóa
                const btnTd = document.createElement('td');
                const btnDiv = document.createElement('div');
                btnDiv.className = 'main__table-btns';
                // Nút Edit
                const editButton = document.createElement('a');
                editButton.href = `/admin/categories/edit/${category.id}`;
                editButton.className = 'main__table-btn main__table-btn--edit';
                editButton.innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                                  <path d="M5,18H9.24a1,1,0,0,0,.71-.29l6.92-6.93h0L19.71,8a1,1,0,0,0,0-1.42L15.47,2.29a1,1,0,0,0-1.42,0L11.23,5.12h0L4.29,12.05a1,1,0,0,0-.29.71V17A1,1,0,0,0,5,18ZM14.76,4.41l2.83,2.83L16.17,8.66,13.34,5.83ZM6,13.17l5.93-5.93,2.83,2.83L8.83,16H6ZM21,20H3a1,1,0,0,0,0,2H21a1,1,0,0,0,0-2Z" />
                                              </svg>`;
                btnDiv.appendChild(editButton);

                // Nút Delete
                const deleteButton = document.createElement('button');
                deleteButton.className = 'main__table-btn main__table-btn--delete';
                deleteButton.innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                                  <path d="M20,6H16V5a3,3,0,0,0-3-3H11A3,3,0,0,0,8,5V6H4A1,1,0,0,0,4,8H5V19a3,3,0,0,0,3,3h8a3,3,0,0,0,3-3V8h1a1,1,0,0,0,0-2ZM10,5a1,1,0,0,1,1-1h2a1,1,0,0,1,1,1V6H10Zm7,14a1,1,0,0,1-1,1H8a1,1,0,0,1-1-1V8H17Z" />
                                                </svg>`;
                deleteButton.onclick = function () {
                    if (confirm('Bạn có chắc chắn muốn xóa danh mục này?')) {
                        fetch(`http://localhost:8080/api/admin/categories/${category.id}`, {
                            method: 'DELETE'
                        })
                            .then(response => {
                                if (response.ok) {
                                    tbody.removeChild(row); // Xóa hàng khỏi bảng
                                    return response.json();
                                } else {
                                    console.error('Error deleting category:', response.statusText);
                                }
                            })
                            .then(data => {
                                alert(data.message); // Hiển thị thông báo
                            })
                            .catch(error => {
                                console.error('Error deleting category:', error);
                                alert('Đã xảy ra lỗi khi xóa thể loại');
                            });
                    }
                };
                btnDiv.appendChild(deleteButton);

                btnTd.appendChild(btnDiv);
                row.appendChild(btnTd);

                // Thêm dòng vào bảng
                tbody.appendChild(row);
            });

        })
        .catch(error => console.error('Error fetching categories: ', error.message));
});

document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('createCategoryForm');
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent traditional form submission

        const formData = new FormData(form);
        fetch('http://localhost:8080/api/admin/categories', {
            method: 'POST',
            body: formData
        })
            .then(response => {
                if (!response.ok) {
                    return response.json().then(error => {
                        throw new Error(error.message || 'Network response was not ok');
                    });
                }
                return response.json();
            })
            .then(data => {
                if (data.message) {
                    alert(data.message); // Display success message
                    form.reset(); // Reset form after successful submission
                    window.location.href = '/admin/categories';
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Đã xảy ra lỗi trong quá trình tạo thể loại');
            });
    });
});

