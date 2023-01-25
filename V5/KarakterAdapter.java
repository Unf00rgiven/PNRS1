package rad.sa.listama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class KarakterAdapter extends BaseAdapter {

    private Context nContext;
    private ArrayList<Karakter> nCharacter;

    public KarakterAdapter(Context context)
    {
        nContext = context;
        nCharacter = new ArrayList<Karakter>();
    }

    public void AddCharacter(Karakter character){
        nCharacter.add(character);
        notifyDataSetChanged();
    }



    @Override
    public int getCount() {
        return nCharacter.size();
    }

    @Override
    public Object getItem(int position) {
        Object returnObject = null;

        try {
            returnObject = nCharacter.get(position);
        }catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return returnObject;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) nContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.lista, null);

            ViewFolder folder = new ViewFolder();
            folder.text = view.findViewById(R.id.textview);
            folder.image = view.findViewById(R.id.image);
            view.setTag(folder);

        }

        Karakter character = (Karakter) getItem(position);
        ViewFolder folder = (ViewFolder) view.getTag();

        folder.image.setImageDrawable(character.getNimage());
        folder.text.setText(character.getNtext());

        return view;
    }

    private class ViewFolder{
        public ImageView image = null;
        public TextView text = null;
    }

}
