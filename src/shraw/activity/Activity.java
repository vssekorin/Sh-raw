package shraw.activity;

import shraw.Named;

public interface Activity extends Named {

    void undo();

    void redo();
}
