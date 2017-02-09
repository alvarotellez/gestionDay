package es.iesnervion.atellez.gestionday.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.util.Date;

import es.iesnervion.atellez.gestionday.R;
import pl.rspective.pagerdatepicker.PagerDatePickerDateFormat;
import pl.rspective.pagerdatepicker.adapter.DatePagerFragmentAdapter;
import pl.rspective.pagerdatepicker.adapter.DefaultDateAdapter;
import pl.rspective.pagerdatepicker.view.DateRecyclerView;
import pl.rspective.pagerdatepicker.view.RecyclerViewInsetDecoration;

/**
 * Created by atellez on 8/02/17.
 */

public class ResumenFragment extends Fragment{

    private DateRecyclerView dateList;
    private ViewPager pager;

    public static ResumenFragment newInstance() {
        return new ResumenFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_resumen, container, false);
    }


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pager = (ViewPager) view.findViewById(R.id.pager);
        dateList = (DateRecyclerView) view.findViewById(R.id.date_list);

        dateList.addItemDecoration(new RecyclerViewInsetDecoration(getActivity(), R.dimen.date_card_insets_default));

        Date start = null;
        Date end = null;
        Date defaultDate = null;

        try {
            start = PagerDatePickerDateFormat.DATE_PICKER_DD_MM_YYYY_FORMAT.parse("02-09-2017");
            end = PagerDatePickerDateFormat.DATE_PICKER_DD_MM_YYYY_FORMAT.parse("02-12-2020");

            defaultDate = PagerDatePickerDateFormat.DATE_PICKER_DD_MM_YYYY_FORMAT.parse("01-04-2015");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        dateList.setAdapter(new DefaultDateAdapter(start, end, defaultDate));


    }
}
