var exercicios;

const url = "http://localhost:8080/avaliacoes/"
const pacientes = "http://localhost:8080/pacientes/cpf/"

const cpf = localStorage.getItem('cpf');

var urlUser = url + cpf;
var urlPac = pacientes + cpf;

async function getAPI(url) {
    try {
        const response = await fetch(url, { method: "GET" });
        const data = await response.json();
        if (response.ok) {
            console.log(data);
            // Call function to populate dropdown
            populate(data);


        } else {
            console.log("Error fetching data:", response.status);
            console.log("Error fetching data.");
        }
    } catch (error) {
        console.log("An error occurred.");
        console.error("Error:", error);

    }
}

async function getAPIPaciente(urlPac) {
    try {
        const response = await fetch(urlPac, { method: "GET" });
        const dataPac = await response.json();
        if (response.ok) {
            console.log(dataPac);
            // Call function to populate dropdown
            impersonate(dataPac);


        } else {
            console.log("Error fetching data:", response.status);
            alert("Error fetching data.");
        }
    } catch (error) {
        console.log("An error occurred.");
        console.error("Error:", error);

    }
}

function populate(data){

        document.getElementById('titulo').innerHTML = data.titulo;
        document.getElementById('avaliacaotxt').innerHTML = data.avaliacao;
    }

function impersonate(dataPac){

        document.getElementById('nome').innerHTML = dataPac.nome;
        document.getElementById('telefone').innerHTML = dataPac.numeroTelefone;
        document.getElementById('email').innerHTML = dataPac.email;
        document.getElementById('descricao').innerHTML = dataPac.descricaoDoPaciente;
    }

    function imprimir(){


        window.print();
    }



getAPI(urlUser);
getAPIPaciente(urlPac);