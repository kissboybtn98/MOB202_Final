package com.example.test_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.test_demo.student.student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<student> list= new ArrayList<student>();
    EditText et_1, et_2,et_3;
    Button btn_them, btn_xoa, btn_sua;
    TextView tv;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_1 = (EditText) findViewById(R.id.et_id);
        et_2 = (EditText) findViewById(R.id.et_name);
        et_3 = (EditText) findViewById(R.id.et_age) ;
        tv = (TextView) findViewById(R.id.tv_thongbao);
        btn_them = (Button) findViewById(R.id.bt_them);
        btn_xoa = (Button) findViewById(R.id.bt_xoa);
        btn_sua = (Button) findViewById(R.id.bt_sua);
        lv = (ListView) findViewById(R.id.list_view);
        student.soluong = 0;



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                student sv_click = (student) adapterView.getItemAtPosition(i);
                et_1.setText(sv_click.getStudent_id() + "");
                et_2.setText(sv_click.getStudent_name());
                et_3.setText(sv_click.getStudent_age() + "");
            }
        });

        btn_them.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            try {
                tv.setText("");
                int id_sinhvien = Integer.parseInt(et_1.getText().toString());
                String ten_sinhvien = et_2.getText().toString();
                int age_sinhvien = Integer.parseInt(et_3.getText().toString());
                if (findStudentById(id_sinhvien, list) == null) {
                    student sv = new student();
                    student.soluong++;
                    sv.setStudent_id(id_sinhvien);
                    sv.setStudent_name(ten_sinhvien);
                    sv.setStudent_age(age_sinhvien);
                    tv.setText("Thêm thành công !");

                    tv.postDelayed(new Runnable() {
                        public void run() {
                            tv.setText("");
                        }
                    }, 1000);

                    list.add(sv);
                } else
                    tv.setText("Trùng mã số sinh viên hoặc tên sinh viên !");


                tv.postDelayed(new Runnable() {
                    public void run() {
                        tv.setText("");
                    }
                }, 1000);

                showListView(list);
            } catch (NumberFormatException e) {
                tv.setText(e.toString());
            }
        }

    });

        btn_xoa.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            try {
                tv.setText("");
                int id_sinhvien = Integer.parseInt(et_1.getText().toString());
                student sv = findStudentById(id_sinhvien, list);
                if (sv != null) {
                    list.remove(sv);
                    student.soluong--;
                    tv.setText(" Xóa thành công !");
                    tv.postDelayed(new Runnable() {
                        public void run() {
                            tv.setText("");
                        }
                    }, 1000);
                }
                showListView(list);
            } catch (NumberFormatException e) {
                tv.setText(e.toString());
            }
        }
    });

        btn_sua.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            try {
                tv.setText("");
                int id_sinhvien = Integer.parseInt(et_1.getText().toString());
                String ten_sinhvien = et_2.getText().toString();
                int age_sinhvien = Integer.parseInt(et_3.getText().toString());
                student sv = findStudentById(id_sinhvien, list);

                if (sv != null) {
                    int index = list.indexOf(sv);
                    sv.setStudent_name(ten_sinhvien);
                    sv.setStudent_age(age_sinhvien);
                    list.set(index, sv);
                    showListView(list);
                    tv.setText("Cập nhật thành công !");
                    tv.postDelayed(new Runnable() {
                        public void run() {
                            tv.setText("");
                        }
                    }, 1000);
                }
            } catch (NumberFormatException e) {
                tv.setText(e.toString());
            }
        }
    });
}

    public void showListView(ArrayList<student> listsv) {
        //Gán dữ liệu từ ArrayList vào ListView
        ArrayAdapter<student> array_adt = new ArrayAdapter<student>(getApplicationContext(), android.R.layout.simple_list_item_1, listsv);
        lv.setAdapter(array_adt);
    }

    public student findStudentById(int id, ArrayList<student> list_student) {
        for (student std : list_student) {
            if (std.getStudent_id() == id)
                return std;
        }
        return null;
    }


}
