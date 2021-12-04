package App.modules;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    ContextModule(Context context) {
        this.context = context;
    }

    @Named("AppContext")
    @Provides
    public Context context(){
        return context;
    }

}
