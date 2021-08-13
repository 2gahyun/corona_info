$(function(){
    $("#region_select").change(function(){
        let region = $(this).find("option:selected").val();
        getCoronaSidoInfo(region);
    })
    getCoronaSidoInfo("서울")

    function getCoronaSidoInfo(sido){
        $.ajax({
            type:"get",
            url:"http://localhost:8077/api/regional?region="+sido,
            success:function(r){
                console.log(r);
                $("#accDecodeCnt").html(r.data.defCnt);
                $("#newDecodeCnt").html(r.data.incDec);
                $("#isolateCnt").html(r.data.isolIngCnt);
                $("#clearIsolateCnt").html(r.data.isolClearCnt);
                $("#covidDanger span").css("display", "none");
                let danger = r.data.incDec + r.data.diff;
                if(danger >= 200) {
                    $("#covidDanger span").eq(3).css("display", "inline").css("color", "#ff0000");
                }
                else if(danger >= 100) {
                    $("#covidDanger span").eq(2).css("display", "inline").css("color", "#ffcc66");
                }
                else if(danger >= 10) {
                    $("#covidDanger span").eq(1).css("display", "inline").css("color", "#ffcc66");
                }
                else {
                    $("#covidDanger span").eq(0).css("display", "inline").css("color", "#66ff99");
                }
            }
        })
    }
})