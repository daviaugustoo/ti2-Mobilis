const url = "http://localhost:8080/duvidas/";
var  urlPesquisa = "http://localhost:8080/duvidas/"; 
var  urlresposta = "http://localhost:8080/duvidas/"; 

var id;
var duvidaAtual;

// Já começar a pagina com duvidas
pesquisar();

function displayDuvida(Nome, Titulo, Duvida, Resposta, nota) {
    document.getElementById('duvida_paciente').innerHTML = Duvida;
    document.getElementById('nome_paciente').innerHTML = Nome;
    document.getElementById('titulo_duvida').innerText = Titulo;
    document.getElementById('resposta_duvida').innerText = Resposta;
    setStarRating(nota);
}

function setStarRating(nota) {
    document.querySelectorAll('.rate input').forEach(input => {
        input.checked = (parseInt(input.value) === nota);
    });
}

document.addEventListener('DOMContentLoaded', function () {
    var submitButton = document.getElementById('submitRating');

    submitButton.addEventListener('click', function () {
        var selectedRating = document.querySelector('.rate input:checked');
        if (selectedRating && duvidaAtual) {
            var rating = selectedRating.value;
            updateRating(duvidaAtual.id, rating);
        } else {
            alert("Por favor, selecione uma avaliação e uma dúvida.");
        }
    });

    document.querySelectorAll('.rate input').forEach(input => {
        input.addEventListener('change', function () {
            var newRating = parseInt(this.value);
            updateRating(duvidaAtual.id, newRating);
        });
    });
});

document.addEventListener('DOMContentLoaded', function () {
    var registro_form = document.getElementById('duvida_form');

    registro_form.addEventListener('submit', function (event) {
        event.preventDefault(); // Impede o envio do formulário



    });
});


async function pesquisar(){
        
        

        // Obtém os elementos de entrada pelos seus IDs
        var pesquisaElement = document.getElementById('nomePesquisa');
        
        // Recupera os valores dos elementos de entrada
        var pesquisaValue = pesquisaElement ? pesquisaElement.value : null;
        if(pesquisaValue){
            urlpesquisa = "http://localhost:8080/duvidas/buscar?nome=" + pesquisaValue;
        }else{
            urlpesquisa = "http://localhost:8080/duvidas/";
        }

        

        // Cria o objeto data com os valores do formulário
       

     

        // Envia os dados para o servidor
        
            console.log(urlpesquisa);

            getAPI(urlpesquisa);
            

        //
}

async function getAPI(url){
    try {
        const response = await fetch(url, {method: "GET"});
        const data = await response.json();
        if(response.ok) {
            console.log(data);
            populateCardSection(data); // Call function to populate dropdown

            
        } else {
            console.log("Error fetching data:", response.status);
            alert("Error fetching data.");
        }
    } catch (error) {
        console.log("An error occurred.");
        console.error("Error:", error);
        
    }
}



function populateCardSection(data) {
    const cardSection = document.querySelector('#cardSection .d-flex');
    cardSection.innerHTML = ''; // Clear any existing cards

    data.forEach(item => {
        // Create card elements
        const card = document.createElement('div');
        card.className = 'card card-block mx-2';
        card.style.minWidth = '300px';

        const cardBody = document.createElement('div');
        cardBody.className = 'card-body';

        const cardTitle = document.createElement('h5');
        cardTitle.className = 'card-title';
        cardTitle.textContent = item.nome; // Replace 'titulo' with the appropriate property of your data

        const cardText = document.createElement('p');
        cardText.className = 'card-text';
        cardText.textContent = item.titulo; // Replace 'duvida' with the appropriate property of your data

        const cardLink = document.createElement('a');
        cardLink.href = '#';
        cardLink.className = 'btn btn-primary custom-primary';
        cardLink.textContent = 'Ver Duvida';
        cardLink.addEventListener('click', function() {
            displayDuvida(item.nome, item.titulo, item.duvida, item.resposta, item.nota); // Adjust this if the property names are different
            duvidaAtual = item;
        });

        // Append elements to card
        cardBody.appendChild(cardTitle);
        cardBody.appendChild(cardText);
        cardBody.appendChild(cardLink);
        card.appendChild(cardBody);

        // Append card to card section
        cardSection.appendChild(card);
    });
}

document.addEventListener('DOMContentLoaded', function () {
    var submitButton = document.getElementById('submitRating');

    submitButton.addEventListener('click', function () {
        var selectedRating = document.querySelector('.rate input:checked');
        if (selectedRating && duvidaAtual) {
            var rating = selectedRating.value;
            updateRating(duvidaAtual.id, rating);
        } else {
            alert("Please select a rating and a question.");
        }
    });
});

async function updateRating(id, rating) {
    const url = `http://localhost:8080/duvidas/${id}/nota?nota=${rating}`;
    try {
        const response = await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        if (response.ok) {
            const data = await response.json();
            console.log('Success:', data);
            alert('Avaliação enviada com sucesso!');
            duvidaAtual.nota = rating;
        } else {
            console.log('Error updating rating:', response.status);
            alert('Erro ao enviar avaliação.');
        }
    } catch (error) {
        console.log('An error occurred:', error);
        alert('Erro ao enviar avaliação.');
    }
}


