package ca.qc.cgmatane.informatique.monmagasinage.adaptater;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ca.qc.cgmatane.informatique.monmagasinage.R;
import ca.qc.cgmatane.informatique.monmagasinage.donnees.UniteDAO;
import ca.qc.cgmatane.informatique.monmagasinage.modele.LigneCourse;
import ca.qc.cgmatane.informatique.monmagasinage.modele.Produit;
import ca.qc.cgmatane.informatique.monmagasinage.modele.pluriel.LignesCourse;
import ca.qc.cgmatane.informatique.monmagasinage.modele.pluriel.Produits;
import ca.qc.cgmatane.informatique.monmagasinage.modele.pluriel.Unites;

public class ListViewLigneCourseAdaptater extends BaseAdapter {
    private Unites listeUnites;
    private LignesCourse panier;
    private LayoutInflater layoutInflater = null;
    private Activity context;

    public ListViewLigneCourseAdaptater(LignesCourse ligneCourses, Activity context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        listeUnites = UniteDAO.getInstance().getListeUnite();
        panier = ligneCourses;
    }

    @Override
    public int getCount() {
        return panier.size();
    }

    @Override
    public Object getItem(int position) {
        return panier.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.ligne_listview_produit, null);

            TextView textViewNomProduit = (TextView) convertView.findViewById(R.id.ligne_listview_produit_nom_produit);
            Spinner spinnerQuantite = (Spinner) convertView.findViewById(R.id.ligne_listview_produit_spinner_quantite);
            Spinner spinnerUnite = (Spinner) convertView.findViewById(R.id.ligne_listview_produit_spinner_unite);
            Button actionLigneProduit = (Button) convertView.findViewById(R.id.ligne_listview_produit_button_action);

            spinnerUnite.setAdapter(listeUnites.recuperAdapterPourSpinner(context));
            List<String> listPourSpinner = new ArrayList<String>();
            for (int i = 1;i<10;i++){
                listPourSpinner.add(i + "");
            }
            //TODO à faire ailleur pour eviter de la faire à chaque ligne
            spinnerQuantite.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, listPourSpinner));

            actionLigneProduit.setText("Suppr");
            final LigneCourse ligneCourse = panier.get(position);
            if(ligneCourse != null && ligneCourse.getProduit() != null){
                //TODO gérer les unité
                textViewNomProduit.setText(ligneCourse.getProduit().getNom().toLowerCase());
                spinnerUnite.setSelection(listeUnites.retournerPositionDansLaListe(ligneCourse.getProduit().getUniteDefaut().getId()));
                spinnerQuantite.setSelection(ligneCourse.getQuantite()-1);
            }


            return convertView;
        }
        return convertView;

    }

    public LignesCourse getPanier() {
        return panier;
    }

    public void setPanier(LignesCourse panier) {
        this.panier = panier;
    }
}