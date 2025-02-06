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
            exercicios = data; // Call function to populate dropdown
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
    for (var i = 0; i < exercicios.length; i++) {
        // Adiciona os elementos HTML para cada dia da semana
        const days = ['segunda', 'terca', 'quarta', 'quinta', 'sexta', 'sabado', 'domingo'];
        const dayValues = days.map(day => exercicios[i][day] ? `<a href="#"><strong>${exercicios[i].nome}</strong> <br> ${exercicios[i].descricaoExercicio}</a>` : ' --- ').join('</td><td>');

        // Generate the star rating HTML based on the 'nota' property
        const rating = exercicios[i].nota || 0;
        const starRating = [...Array(5)].map((_, index) => `
            <input type="radio" id="star${5 - index}-${exercicios[i].id}" name="rate-${exercicios[i].id}" value="${5 - index}" ${rating === 5 - index ? 'checked' : ''} disabled />
            <label for="star${5 - index}-${exercicios[i].id}" title="text">${5 - index} stars</label>
        `).join('');

        // Add the row to the table
        document.getElementById('linhas').innerHTML += `
            <tr>
                <td>${dayValues}</td>
                <td>
                    <div class="rate">
                        ${starRating}
                    </div>
                </td>
            </tr>
        `;
    }
}

getAPI(urlUser);
