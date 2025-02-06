const url = "http://localhost:8080/avaliacoes/";

document.addEventListener('DOMContentLoaded', function () {
    var form = document.getElementById('avalForm');

    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Impede o envio do formulário


    });
});


function registrarAvaliacao() {

    var nomeElement = document.getElementById('nome');
    var cpfElement = document.getElementById('cpf');
    var terminoElement = document.getElementById('termino');
    var avalElement = document.getElementById('avaliacao');
    var tituloElement = document.getElementById('titulo');


    // Recupera os valores dos elementos de entrada
    var nomeValue = nomeElement.value;
    var cpfValue = cpfElement.value;
    var terminoValue = terminoElement.value;
    var avalValue = avalElement.value;
    var tituloValue = tituloElement.value;


    // Cria o objeto data com os valores do formulário
    const data = {
        nome: nomeValue,
        cpf: cpfValue,
        titulo: tituloValue,
        avaliacao: avalValue,
        termino: terminoValue
    };



    // Envia os dados para o servidor

    postData(url, data);



}

async function postData(url, data) {
    try {
        const response = await fetch(url, {
            method: "POST", // Método POST
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
        alert("Avaliação Registrada com Sucesso!");
        // window.location.href = "index.html";
        return responseData; // Retorna os dados da resposta
    } catch (error) {
        console.error('Erro:', error);
    }
}