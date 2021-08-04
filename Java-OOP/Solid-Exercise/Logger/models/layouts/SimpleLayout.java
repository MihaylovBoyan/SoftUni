package Logger.models.layouts;

import Logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }


}
