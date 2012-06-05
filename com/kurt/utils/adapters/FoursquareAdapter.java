import android.widget.ArrayAdapter;


public class FoursquareAdapter extends ArrayAdapter<FoursquareMinivenue> {
	
	Context context; 
    int layoutResourceId;    
    FoursquareVO data[] = null;
	
	public FoursquareAdapter(Context context, int layoutResourceId, FoursquareVO[] data) {
		super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        FoursquareHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new FoursquareHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            
            row.setTag(holder);
        }
        else
        {
            holder = (WeatherHolder)row.getTag();
        }
        
        FoursquareVO fsVO = data[position];
        holder.txtTitle.setText(fsVO.title);
        holder.imgIcon.setImageResource(fsVO.icon);
        
        return row;
    }
	
	static class FoursquareHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}
