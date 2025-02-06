const urlExercicio = "http://localhost:8080/exercicios/";
const urlFicha = "http://localhost:8080/fichas/";

var numExercicio = 1;


$(function(){
    $("#form-total").steps({
        headerTag: "h2",
        bodyTag: "section",
        transitionEffect: "fade",
        enableAllSteps: true,
        stepsOrientation: "vertical",
        autoFocus: true,
        transitionEffectSpeed: 500,
        titleTemplate : '<div class="title">#title#</div>',
        labels: {
            previous : '<i class="zmdi zmdi-arrow-left"></i>',
            next : '<i class="zmdi zmdi-arrow-right"></i>',
            finish : '<i class="zmdi zmdi-check"></i>',
            current : ''
        },
        onFinished: function (event, currentIndex) {
            // Sua função personalizada a ser executada na conclusão do formulário
            criarFicha();
            for(i=1; i<numExercicio;i++){
                criarExercicio(i);
            }
            alert("Cadastro de ficha concluido!");
            window.location.href="menu_profissional.html"

        }
    });

    var dataFicha; 
function criarFicha(){
console.log("Formulário concluído!");
   
    var cpfElement = document.getElementById('cpf');
    var nomeElement = document.getElementById('nome');
    var inicioElement = document.getElementById('inicio');
    var terminoElement = document.getElementById('termino');
    var descFicha = document.getElementById('desc');

    // Recupera os valores dos elementos de entrada
    var cpfValue = cpfElement.value;
    var nomeValue = nomeElement.value;
    var inicioValue = inicioElement.value;
    var terminoValue =  terminoElement.value;
    var descFichaValue = descFicha ? descFicha.value : " ";


    dataFicha = {
        cpf: cpfValue,
        nome: nomeValue,
        descricaoFicha: descFichaValue,
        termino: terminoValue,
        inicio: inicioValue
        
    };
    postDataFicha(urlFicha, dataFicha);
    
}


});





async function postDataFicha(urlFicha, dataFicha) {
    try {
        const response = await fetch(urlFicha, {
            method: "POST", // Método POST
            headers: {
                "Content-Type": "application/json" // Cabeçalho para informar que o corpo da requisição é JSON
            },
            body: JSON.stringify(dataFicha) // Converte o objeto data para JSON
        });

        if (!response.ok) {
            // Se a resposta não for ok (status code 200-299), lança um erro
            const message = `An error has occurred: ${response.status}`;
            throw new Error(message);
        }

        const responseData = await response.json(); // Parse do JSON da resposta
        console.log('Sucesso:', responseData);
        console.log("Conta Registrada com Sucesso!");
        // window.location.href = "index.html";
        return responseData; // Retorna os dados da resposta
    } catch (error) {
        console.error('Erro:', error);
    }
}




function addExercicio() {
    let divExercicios = document.getElementById('divExercicios');

    // Criar div de exercício
    let divExercicio = document.createElement('div');
    divExercicio.classList.add('bond_items');

    // Criar input para o nome do exercício
    let inputExercicio = document.createElement('input');
    inputExercicio.type = 'text';
    inputExercicio.classList.add('form-control');
    inputExercicio.placeholder = 'Exercício';
    inputExercicio.id = 'exercicio' + numExercicio;
    divExercicio.appendChild(inputExercicio);

    // Criar input para a descrição do exercício
    let inputDescricao = document.createElement('input');
    inputDescricao.type = 'text';
    inputDescricao.classList.add('form-control');
    inputDescricao.placeholder = 'Descrição';
    inputDescricao.id = 'descricao' + numExercicio;
    divExercicio.appendChild(inputDescricao);

    // Criar div para os checkboxes dos dias da semana
    let divBotoesSemana = document.createElement('div');
    divBotoesSemana.classList.add('butoesSemana');

    // Criar grupo de checkboxes
    let checkboxGroup = document.createElement('div');
    checkboxGroup.classList.add('btn-group', 'dias-da-semana');
    checkboxGroup.setAttribute('role', 'group');
    checkboxGroup.setAttribute('aria-label', 'Basic checkbox toggle button group');

    // Adicionar checkboxes para cada dia da semana
    let diasSemana = ['Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab', 'Dom'];
    diasSemana.forEach(dia => {
        let inputCheckbox = document.createElement('input');
        inputCheckbox.type = 'checkbox';
        inputCheckbox.classList.add('btn-check');
        inputCheckbox.id = 'btncheck' + numExercicio + dia;
        inputCheckbox.autocomplete = 'off';

        let labelCheckbox = document.createElement('label');
        labelCheckbox.classList.add('btn', 'btn-outline-primary');
        labelCheckbox.htmlFor = 'btncheck' + numExercicio + dia;
        labelCheckbox.textContent = dia;

        checkboxGroup.appendChild(inputCheckbox);
        checkboxGroup.appendChild(labelCheckbox);
    });

    divBotoesSemana.appendChild(checkboxGroup);
    divExercicio.appendChild(divBotoesSemana);

    // Adicionar botão para remover o exercício
    let removeButton = document.createElement('button');
    removeButton.classList.add('btn', 'btn-danger', 'remove-exercicio');
    removeButton.textContent = '';
    removeButton.onclick = function() {
        divExercicios.removeChild(divExercicio);
    };
    divExercicio.appendChild(removeButton);

    // Adicionar div de exercício ao divExercicios
    divExercicios.appendChild(divExercicio);

    numExercicio += 1;
}


var dataExercicio;

        function criarExercicio(id) {
            console.log("Formulário de exercício concluído!");

            var cpfElement = document.getElementById('cpf');
            var exercicioElement = document.getElementById(`exercicio${id}`);
            var descricaoExercicioElement = document.getElementById(`descricao${id}`);
            var segundaElement = document.getElementById(`btncheck${id}Seg`);
            var tercaElement = document.getElementById(`btncheck${id}Ter`);
            var quartaElement = document.getElementById(`btncheck${id}Qua`);
            var quintaElement = document.getElementById(`btncheck${id}Qui`);
            var sextaElement = document.getElementById(`btncheck${id}Sex`);
            var sabadoElement = document.getElementById(`btncheck${id}Sab`);
            var domingoElement = document.getElementById(`btncheck${id}Dom`);

            var cpfValue = cpfElement.value;
            var nomeValue = exercicioElement.value;
            var descricaoExercicioValue = descricaoExercicioElement.value;
            var segundaValue = segundaElement.checked ? 1 : 0;
            var tercaValue = tercaElement.checked ? 1 : 0;
            var quartaValue = quartaElement.checked ? 1 : 0;
            var quintaValue = quintaElement.checked ? 1 : 0;
            var sextaValue = sextaElement.checked ? 1 : 0;
            var sabadoValue = sabadoElement.checked ? 1 : 0;
            var domingoValue = domingoElement.checked ? 1 : 0;

            dataExercicio = {
                cpf: cpfValue,
                nome: nomeValue,
                descricaoExercicio: descricaoExercicioValue,
                segunda: segundaValue,
                terca: tercaValue,
                quarta: quartaValue,
                quinta: quintaValue,
                sexta: sextaValue,
                sabado: sabadoValue,
                domingo: domingoValue
            };

            postDataExercicio(urlExercicio, dataExercicio);
        }

        

        async function postDataExercicio(urlExercicio, dataExercicio) {
            try {
                const response = await fetch(urlExercicio, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(dataExercicio)
                });

                if (!response.ok) {
                    const message = `An error has occurred: ${response.status}`;
                    throw new Error(message);
                }

                const responseData = await response.json();
                console.log('Sucesso:', responseData);
                console.log("Exercício registrado com sucesso!");
                return responseData;
            } catch (error) {
                console.error('Erro:', error);
            }
        }