package ca.qc.cgmatane.informatique.monmagasinage.adaptater;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import ca.qc.cgmatane.informatique.monmagasinage.R;
import ca.qc.cgmatane.informatique.monmagasinage.modele.Course;
import ca.qc.cgmatane.informatique.monmagasinage.modele.LigneCourse;
import ca.qc.cgmatane.informatique.monmagasinage.modele.pluriel.Unites;

public class ListViewLigneFaireCourseAdapter extends ArrayAdapter<LigneCourse> {
    private Course course;
    private Unites listeUnites;
    private Course courseActuelle;
    private Context monContext;
    private ArrayAdapter<String> adaptaterQuantite;
    private static class VueBloqueFaireCourse {
        TextView textViewNomProduit;
        TextView textViewQuantite;
        TextView textViewUnite;
        CheckBox checkBoxLigneProduit;
    }
    public ListViewLigneFaireCourseAdapter(Course course,  Activity context) {
        super(context, R.layout.ligne_listview_faire_course);
        this.monContext = context;
        courseActuelle = course;
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

    }
    @Override
    public LigneCourse getItem(int position) {
        return course.getMesLignesCourse().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LigneCourse ligneCourse = (LigneCourse) this.getItem(position);
        System.out.println("ozifijoizejfoizjfoizjfoizejfzeoijfzeojfzio");
        System.out.println("ozifijoizejfoizjfoizjfoizejfzeoijfzeojfzio");
        System.out.println("ozifijoizejfoizjfoizjfoizejfzeoijfzeojfzio");
        System.out.println("ozifijoizejfoizjfoizjfoizejfzeoijfzeojfzio");
        System.out.println("ozifijoizejfoizjfoizjfoizejfzeoijfzeojfzio");
        System.out.println("ozifijoizejfoizjfoizjfoizejfzeoijfzeojfzio");
        System.out.println("ozifijoizejfoizjfoizjfoizejfzeoijfzeojfzio");
        System.out.println("ozifijoizejfoizjfoizjfoizejfzeoijfzeojfzio");
        VueBloqueFaireCourse vueBloqueFaireCourse;
        final View result;
        if (convertView == null) {
            //convertView = layoutInflater.inflate(R.layout.ligne_listview_produit, null);
            vueBloqueFaireCourse = new VueBloqueFaireCourse();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.ligne_listview_faire_course, parent, false);

            vueBloqueFaireCourse.textViewNomProduit = convertView.findViewById(R.id.ligne_listview_faire_course_nom_produit);
            vueBloqueFaireCourse.textViewQuantite =  convertView.findViewById(R.id.ligne_listview_faire_course_quantite);
            vueBloqueFaireCourse.textViewUnite = convertView.findViewById(R.id.ligne_listview_faire_course_unite);
            vueBloqueFaireCourse.checkBoxLigneProduit = convertView.findViewById(R.id.ligne_listview_faire_course_check_box);


            result=convertView;
            convertView.setTag(vueBloqueFaireCourse);
        }else {
            vueBloqueFaireCourse = (VueBloqueFaireCourse) convertView.getTag();
            result=convertView;
        }
        Animation animation = AnimationUtils.loadAnimation(monContext, (position > lastPosition) ? R.anim.haut_vers_le_bas : R.anim.bas_vers_le_haut);
        result.startAnimation(animation);
        lastPosition = position;


        vueBloqueFaireCourse.textViewNomProduit.setText(ligneCourse.getProduit().getNom());
        vueBloqueFaireCourse.textViewUnite.setText(ligneCourse.getUnite().getLibelle());
        vueBloqueFaireCourse.textViewQuantite.setText(ligneCourse.getQuantite());
     /*   vueBloqueFaireCourse.checkBoxLigneProduit.setSelected(ligneCourse.isCoche());
        vueBloqueFaireCourse.checkBoxLigneProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast message = Toast.makeText(monContext, //display toast message
                        "Check", Toast.LENGTH_SHORT);
                message.show();
            }
        });*/
        return convertView;
    }
}