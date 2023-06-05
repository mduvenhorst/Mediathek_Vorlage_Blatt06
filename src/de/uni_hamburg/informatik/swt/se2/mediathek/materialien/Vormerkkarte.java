package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.ArrayList;
import java.util.LinkedList;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * 
 */
public class Vormerkkarte {

    private final Medium _medium;
    private ArrayBlockingQueue<Kunde> _vormerker;

    /**
     * Konstruktor für Vormerkkarten.
     * @param medium Das Medium für das die Vormerkkarte angelegt werden soll.
     * 
     * @require medium != null
     */
    public Vormerkkarte(Medium medium)
    {
        assert medium != null : "Medium darf nicht null sein";

        _medium = medium;
        _vormerker = new ArrayBlockingQueue<Kunde>(3);
    }

    /**
     * Gibt den ersten Vormerker aus.
     * @return Gibt den ersten Vormerker zurück.
     */
    public Kunde getVormerker()
    {
        return _vormerker.peek();
    }

    /**
     * Setzt einen weitern Vormerker in die Schlange.
     * @param kunde Der Kunde der in die Warteschlange kommt.
     * 
     * @require kunde != null
     */
    public void setVormerker(Kunde kunde)
    {
        if (istVormerkbar())
        {
            _vormerker.offer(kunde);
        }

    }

    /**
     * Löscht den ersten Vormerker.
     */
    public void loescheVormerker()
    {
        _vormerker.poll();
    }

    /**
     * Prüft ob der Kunde Vormerker ist.
     * @param kunde Ist der Kunde für den geprüft wird.
     * 
     * @return Gibt zurück ob der Kunde schon in der Warteschlange steht oder nicht.
     * 
     * @require kunde != null
     */
    public boolean istVormerker(Kunde kunde)
    {
        assert kunde != null : "Kunde ist null";

        return _vormerker.contains(kunde);
    }

    public boolean istVormerkbar()
    {
        if ((_vormerker.size() < 3))
        {
            return true;
        }
        return false;
    }

    /** 
     * Gibt das Medium der Verleihkarte zurück.
     * 
     * @return Das Medium der Verleihkarte.
     */
    public Medium getMedium()
    {
        return _medium;
    }

    /**
     * Gibt die Schlange der Vormerker aus.
     * @return Die Schlange der Vormerker.
     */
    public ArrayList<Kunde> getVormerkerListe()
    {
        return new ArrayList<Kunde>(_vormerker);
    }
}
