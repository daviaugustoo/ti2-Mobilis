
var exercicios;
const url = "http://localhost:8080/exercicios/";
const cpf = localStorage.getItem('cpf');
var urlUser = url + cpf;

async function getAPI(url) {
    try {
        const response = await fetch(url, { method: "GET" });
        const data = await response.json();
        if (response.ok) {
            console.log(data);
            exercicios = data;
            populate();
        } else {
            console.log("Error fetching data:", response.status);
            alert("Error fetching data.");
        }
    } catch (error) {
        console.log("An error occurred.");
        console.error("Error:", error);
    }
}

function populate() {
    document.getElementById('linhas').innerHTML = '';
    for (var i = 0; i < exercicios.length; i++) {
        const days = ['segunda'];
        const dayValues = days.map(day => exercicios[i][day] ? `<a href="#"><strong>${exercicios[i].nome}</strong> </a>` : ' --- ').join('</td><td>');

        const rating = exercicios[i].nota || 0;
        const starRating = [...Array(5)].map((_, index) => `
            <input type="radio" id="star${5 - index}-${exercicios[i].id}" name="rate-${exercicios[i].id}" value="${5 - index}" ${rating === 5 - index ? 'checked' : ''} />
            <label for="star${5 - index}-${exercicios[i].id}" title="text">${5 - index} stars</label>
        `).join('');

        const statusCheckbox = `<div class="checkbox-wrapper-5">
  <div class="check">
            <input type="checkbox" id="status-${exercicios[i].id}" ${exercicios[i].status ? 'checked' : ''} onchange="updateStatus('${cpf}',${exercicios[i].id}, this.checked)" />
            <label for="status-${exercicios[i].id}"></label>
  </div>
</div>
            
        `;

        document.getElementById('linhas').innerHTML += `
            <tr>
                <td>${dayValues}</td>
                <td>${statusCheckbox}</td>
                <td>
                    <div class="rate">
                        ${starRating}
                    </div>
                </td>
            </tr>
        `;
    }

    document.querySelectorAll('.rate input').forEach(input => {
        input.addEventListener('change', (event) => {
            const [_, id] = event.target.id.split('-');
            const newRating = parseInt(event.target.value);
            updateRating(cpf, id, newRating);
        });
    });
}

function updateRating(cpf, id, rating) {
    console.log(`http://localhost:8080/exercicios/${cpf}/${id}`);

    fetch(`http://localhost:8080/exercicios/${cpf}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nota_exercicio: rating })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);

            exercicios = exercicios.map(exercicio => {
                if (exercicio.id === parseInt(id)) {
                    exercicio.nota = rating;
                }
                return exercicio;
            });

            recalculateAndUpdateFicha(cpf);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function updateStatus(cpf, id, status) {
    console.log(`http://localhost:8080/exercicios/${cpf}/${id}/status`);

    fetch(`http://localhost:8080/exercicios/${cpf}/${id}/status`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ status_exercicio: status })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);

            exercicios = exercicios.map(exercicio => {
                if (exercicio.id === id) {
                    exercicio.status = status;
                }
                return exercicio;
            });

            // Optionally update UI or perform other actions
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
function updateStatusFicha(statusFicha) {
    console.log(`http://localhost:8080/fichas/${cpf}/status`);


    fetch(`http://localhost:8080/fichas/${cpf}/status`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ status: statusFicha })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);


            // Optionally update UI or perform other actions
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function recalculateAndUpdateFicha(cpf) {
    let totalNota = 0;
    for (let i = 0; i < exercicios.length; i++) {
        totalNota += exercicios[i].nota || 0;
    }
    const mediaExercicios = totalNota / exercicios.length;
    updateRatingFicha(cpf, mediaExercicios);
}

function updateRatingFicha(cpf, rating) {
    console.log(`http://localhost:8080/fichas/${cpf}`);

    fetch(`http://localhost:8080/fichas/${cpf}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nota: rating })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
function Finalizar() {
    if (window.confirm("Deseja finalizar a ficha?")) {
        updateStatusFicha(true)
    } else {
        location.reload();
    }
}


getAPI(urlUser);