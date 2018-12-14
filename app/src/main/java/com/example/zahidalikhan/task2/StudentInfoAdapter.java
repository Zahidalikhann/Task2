package com.example.zahidalikhan.task2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentInfoAdapter extends ArrayAdapter<Student> {
    private Activity context;
    private List<Student> studentsList;

    public StudentInfoAdapter(Activity context, List<Student>studentsList){
        super(context, R.layout.list_view,studentsList);
        this.context=context;
        this.studentsList=studentsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listview = inflater.inflate(R.layout.list_view, null, true);

        TextView studentName = (TextView) listview.findViewById(R.id.name);
        TextView studentClass = (TextView) listview.findViewById(R.id.class_of_the_student);
        TextView studentId = (TextView) listview.findViewById(R.id.studentid);

        Student student = studentsList.get(position);
        studentName.setText(student.getStudentName());
        studentClass.setText(student.getStudentClass());
        studentId.setText(student.getStudentId());

        return listview;
    }
}
