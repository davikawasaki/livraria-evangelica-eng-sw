
var tipoPagamento;
$("#getDataCreditcard").hide();
$(function() {
  $("#tipoPagamento").on("change", function() {
        tipoPagamento = $( "#tipoPagamento option:selected" ).val();
        console.log(tipoPagamento);
        if(tipoPagamento == "cartao"){
           $("#getDataCreditcard").show();
           $("#form-field-1").attr("required", true);
        }else{
            $("#getDataCreditcard").hide();
            $("#form-field-1").attr("required", false);
        }
  })
});

//getDataCreditcard

