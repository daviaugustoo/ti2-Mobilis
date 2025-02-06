var url = "";
var tipoUsuario = 0;

function tipoPro() {
    tipoUsuario = 1;
}

function tipoPac() {
    tipoUsuario = 2;
}

function loginSuccess(user){

        localStorage.setItem('username', user.nome);
        localStorage.setItem('cpf', user.cpf);
        localStorage.setItem('email', user.email);

}

document.addEventListener('DOMContentLoaded', function() {
    var loginForm = document.getElementById('loginForm');

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the form from submitting
        
        if (tipoUsuario == 0) {
            document.getElementById('warning').innerText = 'Selecione um tipo de usuario'
            return; // Avoid continuing execution
        }

        if (tipoUsuario == 1) {
            url = "http://localhost:8080/profissionais/";
        } else if (tipoUsuario == 2) {
            url = "http://localhost:8080/pacientes/";
        }
        
        // Get the input elements by their IDs
        var emailElement = document.getElementById('email');
        var senhaElement = document.getElementById('senha');
        
        // Retrieve the values of the input elements
        var emailValue = emailElement.value;
        var senhaValue = senhaElement.value;

        // Call the API with the url
        getAPI(url, emailValue, senhaValue);
    });
});

async function getAPI(url, email, senha){
    try {
        const response = await fetch(url, {method: "GET"});
        const data = await response.json();
        if(response.ok) {
            // Simulate login process
            // This is where you would check the credentials against the fetched data
            const user = data.find(user => user.email === email && user.senha === senha);
            if(user) {
                console.log("Login successful!");
                // Proceed with login (e.g., redirect to dashboard)
                loginSuccess(user);
                if (tipoUsuario == 1) {
                    window.location.href="menu_profissional.html";
                } else if (tipoUsuario == 2) {
                    window.location.href="menu_paciente.html";
                }
                
            } else {
                console.log("Invalid credentials.");
                document.getElementById('warning').innerText = "Login ou senha invalidos!";
            }
        } else {
            console.log("Error fetching data:", response.status);
            alert("Error fetching data.");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("An error occurred.");
    }
}
