var itemMain = {
    init : function () {

        var _this = this;
        $("#itemType").on("change", function(){
                _this.itemTypeChange();
        });

        _this.itemTypeChange();
    },

    itemTypeChange : function(){
        var itemType = $("#itemType option:selected").val();

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
    }

}

itemMain.init();