const url = "http://localhost:8080/duvidas/";
var urlPesquisa = "http://localhost:8080/duvidas/"; 
var urlresposta = "http://localhost:8080/duvidas/"; 
var id;
var duvidaAtual;

// Already start the page with doubts
pesquisar();

function displayDuvida(Nome, Titulo, Duvida, Resposta, duvida) {
    document.getElementById('duvida_paciente').innerHTML = Duvida;
    document.getElementById('nome_paciente').innerHTML = Nome;
    document.getElementById('titulo_duvida').innerText = Titulo;
    document.getElementById('resposta_duvida').innerText = Resposta;
    duvidaAtual = duvida;
    console.log("duvidaAtual");
    console.log(duvidaAtual);
}

document.addEventListener('DOMContentLoaded', function () {
    var registro_form = document.getElementById('duvida_form');
    registro_form.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent form submission
        responder(); // Call responder function to handle the form submission
    });
});

async function pesquisar() {
    var pesquisaElement = document.getElementById('nomePesquisa');
    var pesquisaValue = pesquisaElement ? pesquisaElement.value : null;
    if (pesquisaValue) {
        urlPesquisa = "http://localhost:8080/duvidas/buscar?nome=" + pesquisaValue;
    } else {
        urlPesquisa = "http://localhost:8080/duvidas/";
    }
    console.log(urlPesquisa);
    getAPI(urlPesquisa);
}

async function getAPI(url) {
    try {
        const response = await fetch(url, { method: "GET" });
        const data = await response.json();
        if (response.ok) {
            console.log(data);
            populateCardSection(data); // Call function to populate card section
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
        cardTitle.textContent = item.titulo; // Replace 'titulo' with the appropriate property of your data

        const cardText = document.createElement('p');
        cardText.className = 'card-text';
        cardText.textContent = item.duvida; // Replace 'duvida' with the appropriate property of your data

        const cardLink = document.createElement('a');
        cardLink.href = '#';
        cardLink.className = 'btn btn-primary  custom-primary';
        cardLink.textContent = 'Ver Duvida';
        cardLink.addEventListener('click', function () {
            console.log(item)
            displayDuvida(item.nome, item.titulo, item.duvida, item.resposta, item); // Adjust this if the property names are different
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

async function responder(){
        
    if (!duvidaAtual) {
        alert('Por favor, selecione uma dúvida primeiro.');
        return;
    }


    // Obtém os elementos de entrada pelos seus IDs
    var respostaElement = document.getElementById('resposta_duvida');
    


    // Recupera os valores dos elementos de entrada
    urlresposta = "http://localhost:8080/duvidas/"+ duvidaAtual.id;
    duvidaAtual.resposta = respostaElement.value;


    // Cria o objeto data com os valores do formulário
    const data = {
        nome: duvidaAtual.nome,
        titulo: duvidaAtual.titulo,
        duvida: duvidaAtual.duvida,
        resposta: duvidaAtual.resposta
    };

 

    // Envia os dados para o servidor
    
        putData(urlresposta, data);
        

    //
}

async function putData(url, data) {
    try {
        const response = await fetch(url, {
            method: "PUT", // Método POST
            headers: {
                "Content-Type": "application/json" // Cabeçalho para informar que o corpo da requisição é JSON
            },
            body: JSON.stringify(data) // Converte o objeto data para JSON
        });

        if (!response.ok) {
            // Se a resposta não for ok (status code 200-299), lança um erro
            const message = `An error has occurred: ${response.status}`;
            throw new Error(message);
        }

        const responseData = await response.json(); // Parse do JSON da resposta
        console.log('Sucesso:', responseData);
        alert("Resposta Registrada com Sucesso!");
        // window.location.href = "index.html";
        return responseData; // Retorna os dados da resposta
    } catch (error) {
        console.error('Erro:', error);
    }
}
