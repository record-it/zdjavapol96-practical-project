package controller;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MenuItem {
    private String label;
    private Runnable action;
}
