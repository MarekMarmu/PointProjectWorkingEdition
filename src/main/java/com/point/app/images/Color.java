package com.point.app.images;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
    BLACK("#000000"),
    WHITE("#FFFFFF"),
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF"),
    YELLOW("#FFFF00"),
    CYAN("#00FFFF"),
    MAGENTA("#FF00FF"),
    MAROON("#800000"),
    OLIVE("#808000"),
    NAVY("#000080"),
    PURPLE("#800080"),
    TEAL("#008080"),
    SILVER("#C0C0C0"),
    GRAY("#808080"),
    DARK_RED("#8B0000"),
    BROWN("#A52A2A"),
    FIREBRICK("#B22222"),
    DARK_GREEN("#006400"),
    DARK_BLUE("#00008B"),
    DARK_CYAN("#008B8B"),
    DARK_MAGENTA("#8B008B"),
    DARK_YELLOW("#CCCC00"),
    DARK_ORANGE("#FF8C00"),
    ROSY_BROWN("#BC8F8F"),
    DARK_SALMON("#E9967A"),
    DARK_VIOLET("#9400D3"),
    DARK_GRAY("#A9A9A9"),
    LIGHT_GRAY("#D3D3D3"),
    PALE_RED("#FFDAB9"),
    LIGHT_YELLOW("#FFFFE0");

    private final String colorCode;
}
