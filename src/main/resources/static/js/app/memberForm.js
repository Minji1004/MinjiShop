var main = {
    init : function () {

        var _this = this;
        $("#btn-edit").on("click", function(){
                _this.edit();
        });

        $("#btn-cancel").on("click", function(){
                _this.cancel();
        });

        $("#btn-update").on("click", function(){
                _this.update();
        });

        $("#btn-delete").on("click", function(){
                _this.delete();
        });

    },

    edit : function(){
       //Button 변경
       $("#btn-edit").addClass("invisible");
       $("#btn-cancel").removeClass("invisible");
       $("#btn-update").removeClass("invisible");
       $("#btn-delete").removeClass("invisible");

       //address readonly 속성 제거
       $('#city').prop('readonly', false);
       $('#street').prop('readonly', false);
       $('#zipcode').prop('readonly', false);

    },

    cancel : function(){
        var id = $("#id").val();
        window.location.href = '/members/searchMember/'+id;
    },

    update : function(){

        var data = {
            city : $('#city').val(),
            street : $('#street').val(),
            zipcode : $('#zipcode').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/member/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href =  '/members/searchMember/'+id;
        }).fail(function(error){
            alert(JSON.stringify(error));
        });


    },

    delete : function(){
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/member/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href =  '/members';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }

}

main.init();