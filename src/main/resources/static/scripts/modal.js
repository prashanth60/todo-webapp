$('#editModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal

    var id = button.data('id'); // Extract info from data-* attributes
    var content = button.data('content');
    var modal = $(this);

    modal.find('#itemContentEdit').val(content);
    modal.find("#modal-title").text("pedo");
  })