package aquarium.repositories;

import aquarium.entities.decorations.Decoration;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class DecorationRepository implements Repository {

    private List<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        return decorations.remove(decoration);
    }

    @Override
    public Decoration findByType(String type) {

        return decorations.stream()
                .filter(decoration -> decoration.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElseThrow(NullPointerException::new);

    }
}
