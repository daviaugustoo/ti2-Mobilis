var exercicios;
const url1 = "http://localhost:8080/exercicios/";
const url2 = "http://localhost:8080/fichas/";
const url3 = "http://localhost:8080/duvidas/";
const url4 = "http://localhost:8080/fichas/";

var data1; var data2; var data3; var data4;


async function getData(){
    
    async function getAPI(url) {
        try {
            const response = await fetch(url, { method: "GET" });
            const data = await response.json();
            if (response.ok) {
                return data;
            } else {
                console.log("Error fetching data:", response.status);
                alert("Error fetching data.");
            }
        } catch (error) {
            console.log("An error occurred.");
            console.error("Error:", error);
        }
    }

    // Fetch data from all URLs
    async function fetchData() {
        data1 = await getAPI(url1);
        data2 = await getAPI(url2);
        data3 = await getAPI(url3);
        data4 = await getAPI(url4);

        kpi1(data1);
        kpi2(data2);
        kpi3(data3);
        kpi4(data4);



        // Do something with the fetched data
        console.log(data1, data2, data3, data4);
    }

    fetchData();
} 

getData();

function kpi1(data) {
    let soma = 0;
    if (data) {
        data.forEach(item => {
            soma += item.nota;
        });
    }
    var MediaExercicios = soma/data.length;
    console.log("Media Exercicios (kpi1)");
    console.log(MediaExercicios);
    var porcentagemkpi1 = (MediaExercicios/5)*100;
    document.getElementById("kpi1txt").innerText = `${porcentagemkpi1.toFixed(1)}%`;
    document.getElementById("desckpi1").innerText = `${MediaExercicios.toFixed(2)}/5`;
    document.getElementById("kpi1bar").style.width = `${porcentagemkpi1}%`;

}

function kpi2(data) {
    let soma = 0;
    if (data) {
        data.forEach(item => {
            soma += item.nota;
        });
    }
    var MediaFichas = soma/data.length;
    console.log("Media Fichas (kpi2)");
    console.log(MediaFichas);
    var porcentagemkpi2 = (MediaFichas/5)*100;
    document.getElementById("kpi2txt").innerText = `${porcentagemkpi2.toFixed(1)}%`;
    document.getElementById("desckpi2").innerText = `${MediaFichas.toFixed(2)}/5`;
    document.getElementById("kpi2bar").style.width = `${porcentagemkpi2}%`;
}

function kpi3(data) {
    let soma = 0;
    if (data) {
        data.forEach(item => {
            soma += item.nota;
        });
    }
    var MediaAval = soma/data.length;
    

    console.log("Media Avaliações (kpi3)");
    console.log(MediaAval);
    var porcentagemkpi3 = (MediaAval/5)*100;
    document.getElementById("kpi3txt").innerText = `${porcentagemkpi3.toFixed(1)}%`;
    document.getElementById("desckpi3").innerText = `${MediaAval.toFixed(2)}/5`;
    document.getElementById("kpi3bar").style.width = `${porcentagemkpi3}%`;


}

function kpi4(data) {
    var fichasTerminadas = 0; // Initialize the counter
    var numTotalFichas =0;
    if (data) {
        data.forEach(item => {
            numTotalFichas += 1;
            if (item.status === true) {
                fichasTerminadas += 1;
            }
        });
        console.log("NumFichasConcluidas:", fichasTerminadas);
        var porcentagemkpi4 = (fichasTerminadas/numTotalFichas)*100;
        document.getElementById("kpi4txt").innerText = `${porcentagemkpi4.toFixed(1)}%`;
        document.getElementById("desckpi4").innerText = `${fichasTerminadas.toFixed(2)} / ${numTotalFichas}`;
        document.getElementById("kpi4bar").style.width = `${porcentagemkpi4}%`;
    } else {
        console.log("No data available");
    }
}