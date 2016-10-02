var tipoPagamento;
$("#getBookData").show();
$("#getMediaData").hide();

$(function() {
  $("#tipoProduto").on("change", function() {
        tipoProduto = $( "#tipoProduto option:selected" ).val();
        console.log(tipoProduto);
        if(tipoProduto == 1){
           $("#getBookData").show();
           $("#getMediaData").hide();
        }else{
            $("#getMediaData").show();
            $("#getBookData").hide();
        }
  })
});

//getDataCreditcard

