
var tipoPagamento;
$("#getDataCreditcard").hide();
$(function() {
  $("#tipoPagamento").on("change", function() {
        tipoPagamento = $( "#tipoPagamento option:selected" ).val();
        console.log(tipoPagamento);
        if(tipoPagamento == "cartao"){
           $("#getDataCreditcard").show();
        }else{
            $("#getDataCreditcard").hide();
        }
  })
});

//getDataCreditcard

