$(function(){
    $.ajax({
        type:"get",
        url:"/api/corona/age/2021-07-01",
        success:function(r){
            let confArr = new Array();
            let confLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                confArr.push(r.data[i].confCase);
                confLabel.push(r.data[i].gubun+"대");
            } 
            let ageChart = new Chart($("#age_chart"), {
                type:"bar",
                options:{
                    responsive:false
                },
                data:{
                    labels:confLabel,
                    datasets:[{
                        label:" 연령대별 확진",
                        data:confArr,
                        backgroundColor:['rgb(240,128,128)']
                    }]
                }
            });
        }
    });
    $.ajax({
        type:"get",
        url:"/api/corona/gen/2021-07-01",
        success:function(r){
            console.log(r);
            let confArr = new Array();
            let confLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                confArr.push(r.data[i].confCase);
                confLabel.push(r.data[i].gubun);
            } 
            let genChart = new Chart($("#gen_chart"), {
                type:"pie",
                options:{
                    responsive:false
                },
                data:{
                    labels:confLabel,
                    datasets:[{
                        label:"성별 확진 비율",
                        data:confArr,
                        backgroundColor:['rgb(255,218,185)', 'rgb(100,149,237)']
                    }]
                }
            });
        }
    });

    $.ajax({
        type:"get",
        url:"/api/coronaInfo/today",
        success:function(r){
            console.log(r);
            $("#accExamCnt").html(r.data.strAccExamCnt);
            $("#decideCnt").html(r.data.strDecideCnt);
            let ctx2 = $("#confirmed_chart");
            let confirmed_chart = new Chart(ctx2, {
                type:"pie",
                options:{
                    responsive:false
                },
                data:{
                    labels:["확진", "음성"],
                    datasets:[{
                        label:"확진/음성",
                        data:[r.data.decideCnt, r.data.examCnt - r.data.decideCnt],
                        backgroundColor:['rgb(220,20,60)', 'rgb(154,205,50)']
                    }]
                }
            })
        }
    })

    $.ajax({
        type:"get",
        url:"/api/sidoInfo/2021-07-01",
        success:function(r){
            console.log(r);
            let sidoName = new Array();
            let defCnt = new Array();

            for(let i=0; i<6; i++){
                let tag = "<tbody class='region-tbody'></tbody>";
                $(".region_confirm_tbl").append(tag);
            }

            for(let i=0; i<r.data.length; i++){
                let sido = r.data[i].gubun;
                let cnt = r.data[i].incDec;
                sidoName.push(sido);
                defCnt.push(cnt);

                // 012 / 3 = 0.xxxx
                // 345 / 3 = 1.xxxx
                // 678 / 3 = 2.xxxx
                console.log(Math.floor(i/3));
                let page = Math.floor(i/3);
                let tag = 
                '<tr>'+
                    '<td>'+r.data[i].gubun+'</td>'+
                    '<td>'+r.data[i].defCnt+'</td>'+
                    '<td>'+r.data[i].incDec+' ▲</td>'+
                +'</tr>'
                $(".region-tbody").eq(page).append(tag);
            }
            $(".region-tbody").eq(0).addClass("active");

            $("#region_next").click(function(){
                let currentPage = Number($(".current").html());
                currentPage++;
                if(currentPage > 6) currentPage = 6; // 상한값 제한
                $(".current").html(currentPage);
                $(".region-tbody").removeClass("active");
                $(".region-tbody").eq(currentPage-1).addClass("active");
            })
            $("#region_prev").click(function(){
                let currentPage = Number($(".current").html());
                currentPage--;
                if(currentPage < 1) currentPage = 1; // 하한값 제한
                $(".current").html(currentPage);
                $(".region-tbody").removeClass("active");
                $(".region-tbody").eq(currentPage-1).addClass("active");
            })

            let ctx = $("#regional_status");
            let regionalChart = new Chart(ctx, {
                type:'bar',
                options:{
                    responsive:false
                },
                data:{
                    labels:sidoName,
                    datasets:[{
                        label:"2021-08-09 신규확진",
                        data:defCnt,
                        backgroundColor:['rgb(220,20,60)']
                    }]
                }
            })
        }
    })

    // let ctx2 = $("#confirmed_chart");
    // let confirmed_chart = new Chart(ctx2, {
    //     type:"pie",
    //     options:{
    //         responsive:false
    //     },
    //     data:{
    //         labels:["확진", "음성"],
    //         datasets:[{
    //             label:"확진/음성",
    //             data:[100, 200],
    //             backgroundColor:['rgb(255, 0, 76)', 'rgb(255, 251, 0)']
    //         }]
    //     }
    // });

    $.ajax({
        type:"get",
        url:"/api/corona/vaccine/2021-07-01",
        success:function(r){
            console.log(r);

            let vacArr = new Array();
            let vacArr2 = new Array();
            let vacLabel = new Array();
            for(let i=0; i<r.data.length; i++){
                vacArr.push(r.data[i].fistCnt);
                vacArr2.push(r.data[i].secondCnt);
                vacLabel.push(r.data[i].region);
            } 

            let ctx3 = $("#vaccine_chart");
            let vaccine_chart = new Chart(ctx3, {
                type:'bar',
                Option:{
                    responsive:false
                },
                data:{
                    labels:vacLabel,
                    datasets:[{
                        label:" 1차 접종현황",
                        data:vacArr,
                        backgroundColor:['rgb(160,82,45)']
                    },
                    {
                        label:" 2차 접종현황",
                        data:vacArr2,
                        backgroundColor:['rgb(222,184,135)']
                    }]
                }
            });
        }
    });

})