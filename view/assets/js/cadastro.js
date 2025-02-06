function inputPaciente() {


    

    document.getElementById('adapt_input').innerHTML = `

                    <div class="wrap-input100 validate-input" data-validate = "Este campo é obrigatório">
                    <input class="input100" type="text" id="cep"  name="cep" placeholder="CEP">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    </span>
                    </div>    


                    <div class="wrap-input100 validate-input" data-validate = "Este campo é obrigatório">
					<input class="input100" type="text" name="numCasa" id="numeroResidencia" placeholder="Número da casa/apt com complemento">
					<span class="focus-input100"></span>
					<span class="symbol-input100">
					<i class="fa fa-user" aria-hidden="true"></i>
					</span>
					</div>

                    <div class="wrap-input100 validate-input" data-validate = "Este campo é obrigatório">
					<input class="input100" type="text" name="descPaciente" id="descPaciente" placeholder="Descrição do Paciente">
					<span class="focus-input100"></span>
					<span class="symbol-input100">
					<i class="fa fa-user" aria-hidden="true"></i>
					</span>
					</div>
    

    `

}

function inputProfissional() {
    document.getElementById('adapt_input').innerHTML = `
    
    <div class="wrap-input100 validate-input" data-validate = "Este campo é obrigatório">
						<input class="input100" type="text" name="registroPro" id="registroPro"  placeholder="Registro Profissional">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
						<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>

    `
}