document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8080/api/admin/films')

        .then(response => response.json())
        .then(data => {
            const tbody = document.getElementById('film_body');
            console.log('Received films:', data);
            data.forEach(film => {
                const row = document.createElement('tr');
                row.setAttribute('data-film-id', film.id);

                // Column for ID
                const idTd = document.createElement('td');
                const idDiv = document.createElement('div');
                idDiv.className = 'main__table-text';
                idDiv.textContent = film.id;
                idTd.appendChild(idDiv);
                row.appendChild(idTd);

                // Column for Name
                const nameTd = document.createElement('td');
                const nameDiv = document.createElement('div');
                nameDiv.className = 'main__table-text';
                nameDiv.textContent = film.name;
                nameTd.appendChild(nameDiv);
                row.appendChild(nameTd);

                // Column for Poster
                const posterTd = document.createElement('td');
                const posterImg = document.createElement('img');
                posterImg.src = film.poster;
                posterImg.alt = 'Film Poster';
                posterImg.style.maxWidth = '100px';
                posterTd.appendChild(posterImg);
                row.appendChild(posterTd);

                // Column for Opening Day
                const openingDayTd = document.createElement('td');
                const openingDayDiv = document.createElement('div');
                openingDayDiv.className = 'main__table-text';
                openingDayDiv.textContent = film.openingday;
                openingDayTd.appendChild(openingDayDiv);
                row.appendChild(openingDayTd);

                // Column for Duration
                const durationTd = document.createElement('td');
                const durationDiv = document.createElement('div');
                durationDiv.className = 'main__table-text';
                durationDiv.textContent = `${film.duration} phút`;
                durationTd.appendChild(durationDiv);
                row.appendChild(durationTd);

                // Column for Country
                const countryTd = document.createElement('td');
                const countryDiv = document.createElement('div');
                countryDiv.className = 'main__table-text';

                // Kiểm tra xem quốc gia có trong film hay không
                // if (film.country_id) {
                //     fetch(`/api/admin/countries/${film.country_id}`) // Replace with your actual API endpoint for country details
                //         .then(response => response.json())
                //         .then(countryData => {
                //             countryDiv.textContent = countryData.name || 'N/A';
                //         })
                //         .catch(error => console.error('Error fetching country:', error));
                // } else {
                //     countryDiv.textContent = 'N/A';
                // }
                countryDiv.textContent= film.country.name || 'N/A';
                countryTd.appendChild(countryDiv);
                row.appendChild(countryTd);

                // Column for Limit Age
                const limitAgeTd = document.createElement('td');
                const limitAgeDiv = document.createElement('div');
                limitAgeDiv.className = 'main__table-text';
                limitAgeDiv.textContent = film.limit_age;
                limitAgeTd.appendChild(limitAgeDiv);
                row.appendChild(limitAgeTd);

                // Column for Buttons
                const btnTd = document.createElement('td');
                const btnDiv = document.createElement('div');
                btnDiv.className = 'main__table-btns';

                // Edit Button
                const editButton = document.createElement('a');
                editButton.href = `/admin/films/edit/${film.id}`;
                editButton.className = 'main__table-btn main__table-btn--edit';
                editButton.innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                            <path d="M5,18H9.24a1,1,0,0,0,.71-.29l6.92-6.93h0L19.71,8a1,1,0,0,0,0-1.42L15.47,2.29a1,1,0,0,0-1.42,0L11.23,5.12h0L4.29,12.05a1,1,0,0,0-.29.71V17A1,1,0,0,0,5,18ZM14.76,4.41l2.83,2.83L16.17,8.66,13.34,5.83ZM6,13.17l5.93-5.93,2.83,2.83L8.83,16H6ZM21,20H3a1,1,0,0,0,0,2H21a1,1,0,0,0,0-2Z" />
                                        </svg>`;
                btnDiv.appendChild(editButton);

                // Delete Button
                const deleteButton = document.createElement('button');
                deleteButton.className = 'main__table-btn main__table-btn--delete';
                deleteButton.innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                              <path d="M20,6H16V5a3,3,0,0,0-3-3H11A3,3,0,0,0,8,5V6H4A1,1,0,0,0,4,8H5V19a3,3,0,0,0,3,3h8a3,3,0,0,0,3-3V8h1a1,1,0,0,0,0-2ZM10,5a1,1,0,0,1,1-1h2a1,1,0,0,1,1,1V6H10Zm7,14a1,1,0,0,1-1,1H8a1,1,0,0,1-1-1V8H17Z" />
                                          </svg>`;
                deleteButton.onclick = function () {
                    if (confirm('Bạn có chắc chắn muốn xóa phim này?')) {
                        fetch(`http://localhost:8080/api/admin/films/${film.id}`, {
                            method: 'DELETE'
                        })
                            .then(response => {
                                if (response.ok) {
                                    tbody.removeChild(row); // Remove row from table
                                    alert('Phim đã được xóa thành công');
                                } else {
                                    console.error('Error deleting film:', response.statusText);
                                }
                            })
                            .catch(error => {
                                console.error('Error deleting film:', error);
                                alert('Đã xảy ra lỗi khi xóa phim');
                            });
                    }
                };
                btnDiv.appendChild(deleteButton);

                btnTd.appendChild(btnDiv);
                row.appendChild(btnTd);

                // Add row to table
                tbody.appendChild(row);
            });

        })
        .catch(error => console.error('Error fetching films:', error));
});
