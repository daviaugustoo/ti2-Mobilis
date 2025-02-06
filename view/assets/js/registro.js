var url = "";

var tipoUsuario = 0;

function tipoPro() {
    tipoUsuario = 1;
}
function tipoPac() {
    tipoUsuario = 2;
}

document.addEventListener('DOMContentLoaded', function () {
    var registro_form = document.getElementById('registro_form');

    registro_form.addEventListener('submit', function (event) {
        event.preventDefault(); // Impede o envio do formulário

        if (tipoUsuario == 0) {
            alert("Selecione um tipo de usuario");
            window.location.reload();
            return; // Adicionado return para evitar continuar a execução
        }
        if (tipoUsuario == 1) {
            url = "http://localhost:8080/profissionais/";
        }
        if (tipoUsuario == 2) {
            url = "http://localhost:8080/pacientes/";
        }

        // Obtém os elementos de entrada pelos seus IDs
        var regElement = document.getElementById('registroPro');
        var emailElement = document.getElementById('email');
        var senhaElement = document.getElementById('senha');
        var cpfElement = document.getElementById('cpf');
        var nomeElement = document.getElementById('nome');
        var telElement = document.getElementById('telefone');
        var cepElement = document.getElementById('cep');
        var numResElement = document.getElementById('numeroResidencia');
        var descPaciente = document.getElementById('descPaciente');

        // Recupera os valores dos elementos de entrada
        var regValue = regElement ? regElement.value : null;
        var emailValue = emailElement.value;
        var senhaValue = senhaElement.value;
        var cpfValue = cpfElement.value;
        var nomeValue = nomeElement.value;
        var telValue = telElement.value;
        var cepValue = cepElement ? cepElement.value : null;
        var numResValue = numResElement ? numResElement.value : null;
        var descPacienteValue = descPaciente ? descPaciente.value : null;

        // Cria o objeto data com os valores do formulário
        const dataPro = {
            nome: nomeValue,
            email: emailValue,
            senha: senhaValue,
            numeroTelefone: telValue,
            codigoProfissional: regValue
        };

        const dataPac = {
            cpf: cpfValue,
            nome: nomeValue,
            email: emailValue,
            senha: senhaValue,
            numeroTelefone: telValue,
            cep : cepValue,
            numeroResidencia: numResValue,
            descricaoDoPaciente: descPacienteValue
        };

        // Envia os dados para o servidor
        if (tipoUsuario == 1) {
            postData(url, dataPro);
            window.location.href="index.html";
        } else if (tipoUsuario == 2) {
            postData(url, dataPac);
            window.location.href="index.html";
        }
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
        alert("Conta Registrada com Sucesso!");
        // window.location.href = "index.html";
        return responseData; // Retorna os dados da resposta
    } catch (error) {
        console.error('Erro:', error);
    }
}
