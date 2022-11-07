function validarFormulario() {
        var y=document.forms["formulario"]["condiciones"].checked;

        if (y == false) {
            alert("Tienes que aceptar los términos y condiciones");
            return false;
        }
    }
