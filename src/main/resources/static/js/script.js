// Máscara para número de telefone
const tel = document.getElementById('telefone') // Seletor do campo telefone

tel.addEventListener('keypress', (e) => mascaraTelefone(e.target.value)) // Dispara quando digitado no campo
tel.addEventListener('change', (e) => mascaraTelefone(e.target.value)) // Dispara quando autocompletado o campo

const mascaraTelefone = (valor) => {
    valor = valor.replace(/\D/g, "")
    valor = valor.replace(/^(\d{2})(\d)/g, "($1) $2")
    valor = valor.replace(/(\d)(\d{4})$/, "$1-$2")
    tel.value = valor // Insere o(s) valor(es) no campo
}

// Máscara para CPF
const cpf = document.getElementById('cpf'); // Seletor do campo de CPF

cpf.addEventListener('keypress', (e) => mascaraCPF(e.target.value)); // Dispara quando digitado no campo
cpf.addEventListener('change', (e) => mascaraCPF(e.target.value)); // Dispara quando autocompletado o campo

const mascaraCPF = (valor) => {
    valor = valor.replace(/\D/g, ""); // Remove todos os caracteres não numéricos
    valor = valor.replace(/^(\d{3})(\d)/, "$1.$2"); // Coloca o ponto após os 3 primeiros dígitos
    valor = valor.replace(/^(\d{3})\.(\d{3})(\d)/, "$1.$2.$3"); // Coloca o ponto após os 6 primeiros dígitos
    valor = valor.replace(/^(\d{3})\.(\d{3})\.(\d{3})(\d)/, "$1.$2.$3-$4"); // Coloca o hífen após os 9 primeiros dígitos
    cpf.value = valor;

}

function validarNumero() {
    let campoDono = document.getElementById('dono').value;
    let popup = document.getElementById('popup');
    if (isNaN(campoDono) || campoDono === "") {
        popup.style.display = 'block';
        setTimeout(function() {
            popup.style.display = 'none';
        }, 3000);
        return false;
    }
    return true;
}