package cf.tmcz.pvm.utils;


import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class TimerCfg {

    private final File file;
    private final YamlConfiguration config;

    public TimerCfg() {
        File dir = new File("./plugins/PVM/");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        this.file = new File(dir, "timer.yml");

        if (!file.exists()) {
            try {

                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getTime() {
        return config;
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
