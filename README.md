Game of Life - Advanced Cellular Simulation

Overview:

The Game of Life is a complex cellular automaton simulation where various types of cells interact in a dynamic environment. Each cell type exhibits unique behaviors, including survival strategies, parasitic relationships, and responses to day and night cycles. This project builds upon Conway’s Game of Life by introducing non-deterministic behaviors, symbiotic relationships, and disease propagation, making it an advanced study in cellular automata and probabilistic modeling.

Key Features:

	•	Diverse Cell Types: Six distinct cell types, each with unique survival and reproduction rules:
	•	Mycoplasma: Reacts differently to day and night cycles, exhibits complex behaviors based on living neighbors.
	•	Clostridium: Changes color and behavior based on neighboring cells and infection status.
	•	Pseudomonas: Delayed activity with specific behaviors triggered after multiple generations.
	•	Bacillus: Non-deterministic behavior modeled with probabilities, leading to varied color changes.
	•	Staph: Exhibits symbiotic relationships and switches behavior based on day/night cycles.
	•	Ecoli: Acts as a host cell and demonstrates parasitic relationships with other cell types.
	•	Non-deterministic Cells: Bacillus cells exhibit probabilistic behavior, simulating real-life variability.
	•	Parasitic Relationships: Interaction between Ecoli and Staph cells represents parasitic behavior, with Ecoli cells being eliminated if attacked by Staph cells.
	•	Disease Mechanism: Specific cells can be infected with a disease that spreads probabilistically to neighboring cells, simulating real-world infection spread.
	•	Day and Night Cycle: Certain cells change behavior based on the simulation’s day and night cycle, adding dynamic variability to the simulation.

Technologies Used:

	•	Java: Core programming language for logic, cellular interactions, and UI.
	•	Object-Oriented Programming (OOP): Designed using responsibility-driven development to ensure modularity and scalability.
	•	Probabilistic Modeling: Randomized behavior for specific cell types, with varying probabilities for survival, infection, and color changes.

Challenge Tasks Implemented:

	•	Non-deterministic Cells: Bacillus cells change their state based on probabilistic thresholds, adding unpredictability.
	•	Symbiotic and Parasitic Relationships: Interaction between Ecoli and Staph cells mimics parasitic relationships, demonstrating complex interdependencies.
	•	Disease Propagation: Infection spreads between cells, with infected cells marked and affected by neighboring healthy cells.
	•	Day/Night Cycles: Certain cells alter their behavior based on time of day, introducing environmental variability to their survival.

Files:

	•	Cell.java: Base class for all cell types, defines general properties and behaviors.
	•	Bacillus.java, Clostridium.java, Ecoli.java: Each class represents a unique cell type with specific behaviors.
	•	Field.java: Defines the grid-based environment where the simulation takes place.
	•	Simulator.java: Core class controlling the simulation, including the day/night cycle and overall simulation flow.
	•	FieldCanvas.java: Manages graphical representation of the field and cells.
