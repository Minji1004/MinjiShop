var itemMain = {
    init : function () {

        var _this = this;
        $("#itemType").on("change", function(){
                _this.itemTypeChange();
        });

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

        _this.itemTypeChange();
    },

    itemTypeChange : function(){
        var itemType = $("#itemType option:selected").val();
        if(itemType == undefined)
            itemType = $("#itemType").val();

       switch(itemType){
            case 'A':
                $("#div-album").css("display", "block");
                $("#div-book").css("display", "none");
                $("#div-movie").css("display", "none");
                break;

            case 'B':
                $("#div-album").css("display", "none");
                $("#div-book").css("display", "block");
                $("#div-movie").css("display", "none");
                break;

            case 'M':
                $("#div-album").css("display", "none");
                $("#div-book").css("display", "none");
                $("#div-movie").css("display", "block");
                break;
       }
    },

    edit : function(){
           //Button 변경
           $("#btn-edit").css("display", "none");
           $("#btn-cancel").css("display", "");
           $("#btn-update").css("display", "");
           $("#btn-delete").css("display", "");

           //readonly 속성 제거
           $('#name').prop('readonly', false);
           $('#price').prop('readonly', false);
           $('#stockQuantity').prop('readonly', false);
           $('#artist').prop('readonly', false);
           $('#etc').prop('readonly', false);
           $('#author').prop('readonly', false);
           $('#isbn').prop('readonly', false);
           $('#director').prop('readonly', false);
           $('#actor').prop('readonly', false);

        },

    cancel : function(){
            var id = $("#id").val();
            window.location.href = '/items/'+id+'/edit';
         },

     update : function(){

         var data = {
           itemType : $('#itemType').val(),
           name : $('#name').val(),
           price : $('#price').val(),
           stockQuantity : $('#stockQuantity').val(),
           artist : $('#artist').val(),
           etc : $('#etc').val(),
           author : $('#author').val(),
           isbn : $('#isbn').val(),
           director : $('#director').val(),
           actor : $('#actor').val()
         };

         var id = $('#id').val();

         $.ajax({
             type: 'PUT',
             url: '/api/item/'+id,
             dataType: 'json',
             contentType: 'application/json; charset=utf-8',
             data: JSON.stringify(data)
         }).done(function(){
             alert('상품 정보가 수정되었습니다.');
             window.location.href =  '/items/'+id+'/edit';
         }).fail(function(error){
             alert(JSON.stringify(error));
         });
       },

    delete : function(){
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/item/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function(){
            alert('상품 정보가 삭제되었습니다.');
            window.location.href =  '/items';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }

}

itemMain.init();