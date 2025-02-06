const url = "http://localhost:8080/duvidas/";



document.addEventListener('DOMContentLoaded', function () {
    var registro_form = document.getElementById('duvida_form');

    registro_form.addEventListener('submit', function (event) {
        event.preventDefault(); // Impede o envio do formulário

        
        //

        // Obtém os elementos de entrada pelos seus IDs
        var nomeElement = document.getElementById('nome');
        var tituloElement = document.getElementById('titulo');
        var duvidaElement = document.getElementById('duvida');


        // Recupera os valores dos elementos de entrada
        var nomeValue = nomeElement.value;
        var tituloValue = tituloElement.value;
        var duvidaValue = duvidaElement.value;
        var respostaValue = "Ainda não respondida!"
  

        // Cria o objeto data com os valores do formulário
        const data = {
            nome: nomeValue,
            titulo: tituloValue,
            duvida: duvidaValue,
            resposta: respostaValue
        };

     

        // Envia os dados para o servidor
        
            postData(url, data);
            

        //

    });
});

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
        alert("Duvida Registrada com Sucesso!");
        // window.location.href = "index.html";
        return responseData; // Retorna os dados da resposta
    } catch (error) {
        console.error('Erro:', error);
    }
}
