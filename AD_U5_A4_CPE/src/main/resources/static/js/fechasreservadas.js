console.log("fechasreservadas.js se ha cargado correctamente.");

$(function() {
	console.log("Entrando a la función de inicialización del Datepicker");
    // Llamada AJAX para obtener las fechas reservadas
    $.getJSON("/reservas/fechas", function(reservedDates) {
        // Inicializa el Datepicker para el campo con id "fechadesde"
        $("#fechadesde").datepicker({
            dateFormat: "yy-mm-dd",
            beforeShowDay: function(date) {
                var formattedDate = $.datepicker.formatDate('yy-mm-dd', date);
                if (reservedDates.indexOf(formattedDate) !== -1) {
                    // Deshabilita la fecha y aplica la clase "reserved-date"
                    return [false, "reserved-date", "Fecha reservada"];
                }
                return [true, "", ""];
            }
        });
        // Inicializa el Datepicker para el campo con id "fechahasta"
        $("#fechahasta").datepicker({
            dateFormat: "yy-mm-dd",
            beforeShowDay: function(date) {
                var formattedDate = $.datepicker.formatDate('yy-mm-dd', date);
                if (reservedDates.indexOf(formattedDate) !== -1) {
                    return [false, "reserved-date", "Fecha reservada"];
                }
                return [true, "", ""];
            }
        });
    });
});
