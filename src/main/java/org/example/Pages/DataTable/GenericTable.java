package org.example.Pages.DataTable;

import java.util.List;

public interface GenericTable {
    List<String> getHeaders();

    TableRow getHeadersRow();

    TableRow getRow(int index);

    List<TableRow> getAllRows();
}
