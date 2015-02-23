package com.example.danialchowdhry.ballgame;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Game.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Game#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Game extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private static int rando;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Game.
     */
    // TODO: Rename and change types and number of parameters
    public static Game newInstance(String param1, String param2) {
        Game fragment = new Game();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, rando);
        fragment.setArguments(args);
        return fragment;
    }

    public Game() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            rando = getArguments().getInt(ARG_PARAM1);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View imview = inflater.inflate(R.layout.fragment_game, container, false);
        ImageView image = (ImageView) imview.findViewById(R.id.ballView);
        switch (rando) {
            case 0:
                image.setImageDrawable(getResources().getDrawable(R.drawable.ball0));
                break;
            case 1:
                image.setImageDrawable(getResources().getDrawable(R.drawable.ball1));
                break;
            case 2:
                image.setImageDrawable(getResources().getDrawable(R.drawable.ball2));
                break;
            case 3:
                image.setImageDrawable(getResources().getDrawable(R.drawable.ball3));
                break;
            case 4:
                image.setImageDrawable(getResources().getDrawable(R.drawable.balls));
                break;
            default:
                image.setImageDrawable(getResources().getDrawable(R.drawable.balls));
                break;
        }
        return imview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
