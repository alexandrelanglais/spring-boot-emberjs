package fr.demandeatonton.model.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.demandeatonton.model.beans.Programmer;

@Repository
public class MemoryRepository {
	private static List<Programmer> programmers = new ArrayList<>(3);

	static {
		programmers.add(new Programmer(1, "Linus Torvalds", "Créateur de Linux"));
		programmers.add(new Programmer(2, "Dennis Ritchie", "Créateur du C"));
		programmers.add(new Programmer(3, "Ken Thompson", "Créateur d'Unix et du B"));
	}

	public Programmer findById(int id) {
		for (Programmer c : programmers) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
}
