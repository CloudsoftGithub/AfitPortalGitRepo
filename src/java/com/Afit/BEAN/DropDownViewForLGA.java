package com.Afit.BEAN;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DropDownViewForLGA implements Serializable {

    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();

    private String state;
    private String lga;
    private Map<String, String> states;
    private Map<String, String> lgas;

    @PostConstruct
    public void init() {
        states = new HashMap<String, String>();
        states.put("ABIA", "ABIA");
        states.put("ADAMAWA", "ADAMAWA");
        states.put("AKWA IBOM", "AKWA IBOM");
        states.put("ANAMBRA", "ANAMBRA");
        states.put("BAUCHI", "BAUCHI");
        states.put("BAYELSA", "BAYELSA");
        states.put("BENUE", "BENUE");
        states.put("BORNU", "BORNU");
        states.put("CROSS RIVER", "BORNU");
        states.put("DELTA", "DELTA");
        states.put("EBONYI", "EBONYI");
        states.put("EDO", "EDO");
        states.put("EKITI", "EKITI");
        states.put("ENUGU", "ENUGU");
        states.put("FCT", "FCT");
        states.put("GOMBE", "GOMBE");
        states.put("IMO", "IMO");
        states.put("JIGAWA", "JIGAWA");
        states.put("KADUNA", "KADUNA");
        states.put("KANO", "KANO");
        states.put("KATSINA", "KATSINA");
        states.put("KEBBI", "KEBBI");
        states.put("KOGI", "KOGI");
        states.put("KWARA", "KWARA");
        states.put("LAGOS", "LAGOS");
        states.put("NASARAWA", "NASARAWA");
        states.put("NIGER", "NIGER");
        states.put("OGUN", "OGUN");
        states.put("ONDO", "ONDO");
        states.put("OSUN", "OSUN");
        states.put("OYO", "OYO");
        states.put("PLATEAU", "PLATEAU");
        states.put("RIVERS", "RIVERS");
        states.put("SOKOTO", "SOKOTO");
        states.put("TARABA", "TARABA");
        states.put("YOBE", "YOBE");
        states.put("ZAMFARA", "ZAMFARA");

        //LGAs under Kano State
        Map<String, String> map = new HashMap<String, String>();
        map.put("Garun-Malam", "Garun-Malam");
        map.put("Ajingi", "Ajingi");
        map.put("Albasu", "Albasu");
        map.put("Bagwai", "Bagwai");
        map.put("Bebeji", "Bebeji");
        map.put("Bichi", "Bichi");
        map.put("Bunkure", "Bunkure");
        map.put("Dambatta", "Dambatta");
        map.put("Dawakin Kudu ", "Dawakin Kudu ");
        map.put("Dawakin Tofa ", "Dawakin Tofa ");
        map.put("Doguwa", "Doguwa");
        map.put("Fagge", "Fagge");
        map.put("Gabasawa", "Gabasawa");
        map.put("Garko", "Garko");
        map.put("Garum", "Garum");
        map.put("Mallam", "Mallam");
        map.put("Gaya", "Gaya");
        map.put("Gezawa", "Gezawa");
        map.put("Gwale", "Gwale");
        map.put("Gwarzo", "Gwarzo");
        map.put("Kabo", "Kabo");
        map.put("Kano Municipal ", "Kano Municipal ");
        map.put("Karaye", "Karaye");
        map.put("Kibiya", "Kibiya");
        map.put("Kiru", "Kiru");
        map.put("kumbotso ", "kumbotso ");
        map.put("Kunchi", "Kunchi");
        map.put("Kura", "Kura");
        map.put("Madobi", "Madobi");
        map.put("Makoda", "Makoda");
        map.put("Minjibir", "Minjibir");
        map.put("Nasarawa", "Nasarawa");
        map.put("Rano", "Rano");
        map.put("Rimin Gado", "Rimin Gado");
        map.put("Rogo", "Rogo");
        map.put("Shanono", "Shanono");
        map.put("Sumaila", "Sumaila");
        map.put("Takai", "Takai");
        map.put("Tarauni", "Tarauni");
        map.put("Tofa", "Tofa");
        map.put("Tsanyawa", "Tsanyawa");
        map.put("Tudun Wada", "Tudun Wada");
        map.put("Ungogo", "Ungogo");
        map.put("Warawa", "Warawa");
        map.put("Wudil", "Wudil");
        data.put("KANO", map);

        //LGAs under Kaduna State
        map = new HashMap<String, String>();
        map.put("Birni-Gwari", "Birni-Gwari");
        map.put("Chikun", "Chikun");
        map.put("Giwa", "Giwa");
        map.put("Igabi", "Igabi");
        map.put("Ikara", "Ikara");
        map.put("jaba", "jaba");
        map.put("Jema'a", "Jema'a");
        map.put("Kachia", "Kachia");
        map.put("Kaduna North", "Kaduna North");
        map.put("Kaduna South", "Kaduna South");
        map.put("Kagarko", "Kagarko");
        map.put("Kajuru", "Kajuru");
        map.put("Kaura", "Kaura");
        map.put("Kauru", "Kauru");
        map.put("Kubau", "Kubau");
        map.put("Kudan", "Kudan");
        map.put("Lere", "Lere");
        map.put("Makarfi", "Makarfi");
        map.put("Sabon-Gari", "Sabon-Gari");
        map.put("Zaria", "Zaria");
        map.put("Sanga", "Sanga");
        map.put("Soba", "Soba");
        map.put("Zango-Kataf", "Zango-Kataf");
        data.put("KADUNA", map);

        //LGAs under Abia State
        map = new HashMap<String, String>();
        map.put("Aba North ", " Aba North ");
        map.put("Aba South ", " Aba South ");
        map.put(" Arochukwu ", "  Arochukwu ");
        map.put(" Bende ", "  Bende ");
        map.put(" Ikwuano ", "  Ikwuano ");
        map.put(" Isiala-Ngwa North ", "  Isiala-Ngwa North ");
        map.put(" Isiala-Ngwa South ", "  Isiala-Ngwa South ");
        map.put(" Isuikwato ", "  Isuikwato ");
        map.put(" Obi Nwa ", "  Obi Nwa ");
        map.put(" Ohafia ", "  Ohafia ");
        map.put(" Osisioma ", "  Osisioma ");
        map.put(" Ngwa ", "  Ngwa ");
        map.put(" Ugwunagbo ", "  Ugwunagbo ");
        map.put(" Ukwa East ", "  Ukwa East ");
        map.put(" Ukwa West ", "  Ukwa West ");
        map.put(" Umuahia North ", "  Umuahia North ");
        map.put(" Umuahia South ", "  Umuahia South ");
        map.put(" Umu-Neochi", "  Umu-Neochi");
        data.put("ABIA", map);

        //LGAs under FCT
        map = new HashMap<String, String>();
        map.put("Gwagwalada", "Gwagwalada");
        map.put("Kuje", "Kuje");
        map.put("Abaji", "Abaji");
        map.put("Abuja Municipal", "Abuja Municipal");
        map.put("Bwari", "Bwari");
        map.put("Kwali", "Kwali");
        data.put("FCT", map);

        //LGAs under Adamawa State
        map = new HashMap<String, String>();
        map.put("Demsa", "Demsa");
        map.put("Fufore", "Fufore");
        map.put("Ganaye", "Ganaye");
        map.put("Gireri", "Gireri");
        map.put("Gombi", "Gombi");
        map.put("Guyuk", "Guyuk");
        map.put("Hong", "Hong");
        map.put("Jada", "Jada");
        map.put("Lamurde", "Lamurde");
        map.put("Madagali", "Madagali");
        map.put("Maiha", "Maiha");
        map.put("Mayo-Belwa", "Mayo-Belwa");
        map.put("Michika", "Michika");
        map.put("Mubi North", "Mubi North");
        map.put("Mubi South", "Mubi South");
        map.put("Numan", "Numan");
        map.put("Shelleng", "Shelleng");
        map.put("Song", "Song");
        map.put("Toungo", "Toungo");
        map.put("Yola North", "Yola North");
        map.put("Yola South", "Yola South");
        data.put("ADAMAWA", map);

        //LGAs under AKWA IBOM State
        map = new HashMap<String, String>();
        map.put("Abak", "Abak");
        map.put("Eastern Obolo", "Eastern Obolo");
        map.put("Eket", "Eket");
        map.put("Esit Eket", "Esit Eket");
        map.put("Essien Udim", "Essien Udim");
        map.put("Etim Ekpo", "Etim Ekpo");
        map.put("Etinan", "Etinan");
        map.put("Ibeno", "Ibeno");
        map.put("Ibesikpo Asutan", "Ibesikpo Asutan");
        map.put("Ibiono Ibom", "Ibiono Ibom");
        map.put("Ika", "Ika");
        map.put("Ikono", "Ikono");
        map.put("Ikot Abasi", "Ikot Abasi");
        map.put("Ikot Ekpene", "Ikot Ekpene");
        map.put("Ini", "Ini");
        map.put("Itu", "Itu");
        map.put("Mbo", "Mbo");
        map.put("Mkpat Enin", "Mkpat Enin");
        map.put("Nsit Atai", "Nsit Atai");
        map.put("Nsit Ibom", "Nsit Ibom");
        map.put("Nsit Ubium", "Nsit Ubium");
        map.put("Obot Akara", "Obot Akara");
        map.put("Okobo", "Okobo");
        map.put("Onna", "Onna");
        map.put("Oron", "Oron");
        map.put("Oruk Anam", "Oruk Anam");
        map.put("Udung Uko", "Udung Uko");
        map.put("Ukanafun", "Ukanafun");
        map.put("Uruan", "Uruan");
        map.put("Urue-Offong/Oruko", "Urue-Offong/Oruko");
        map.put("Uyo", "Uyo");
        data.put("AKWA IBOM", map);

        //LGAs under ANAMBRA State
        map = new HashMap<String, String>();
        map.put("Aguata", "Aguata");
        map.put("Anambra East", "Anambra East");
        map.put("Anambra West", "Anambra West");
        map.put("Anaocha", "Anaocha");
        map.put("Awka North", "Awka North");
        map.put("Awka South", "Awka South");
        map.put("Ayamelum", "Ayamelum");
        map.put("Dunukofia", "Dunukofia");
        map.put("Ekwusigo", "Ekwusigo");
        map.put("Idemili North", "Idemili North");
        map.put("Idemili south", "Idemili south");
        map.put("Ihiala", "Ihiala");
        map.put("Njikoka", "Njikoka");
        map.put("Nnewi North", "Nnewi North");
        map.put("Nnewi South", "Nnewi South");
        map.put("Ogbaru", "Ogbaru");
        map.put("Onitsha North", "Onitsha North");
        map.put("Onitsha South", "Onitsha South");
        map.put("Orumba North", "Orumba North");
        map.put("Orumba South", "Orumba South");
        map.put("Oyi", "Oyi");
        data.put("ANAMBRA", map);

        //LGAs under Bauchi State
        map = new HashMap<String, String>();
        map.put("Alkaleri", "Alkaleri");
        map.put("Bauchi", "Bauchi");
        map.put("Bogoro", "Bogoro");
        map.put("Damban", "Damban");
        map.put("Darazo", "Darazo");
        map.put("Dass", "Dass");
        map.put("Ganjuwa", "Ganjuwa");
        map.put("Giade", "Giade");
        map.put("Itas/Gadau", "Itas/Gadau");
        map.put("Jama'are", "Jama'are");
        map.put("Katagum", "Katagum");
        map.put("Kirfi", "Kirfi");
        map.put("Misau", "Misau");
        map.put("Ningi", "Ningi");
        map.put("Shira", "Shira");
        map.put("Tafawa-Balewa", "Tafawa-Balewa");
        map.put("Toro", "Toro");
        map.put("Warji", "Warji");
        map.put("Zaki", "Zaki");
        data.put("BAUCHI", map);

        //LGAs under BAYELSA State
        map = new HashMap<String, String>();
        map.put("Brass", "Brass");
        map.put("Ekeremor", "Ekeremor");
        map.put("Kolokuma/Opokuma", "Kolokuma/Opokuma");
        map.put("Nembe", "Nembe");
        map.put("Ogbia", "Ogbia");
        map.put("Sagbama", "Sagbama");
        map.put("Southern Jaw", "Southern Jaw");
        map.put("Yenegoa", "Yenegoa");
        data.put("BAYELSA", map);

        //LGAs under BENUE State
        map = new HashMap<String, String>();
        map.put("Ado", "Ado");
        map.put("Agatu", "Agatu");
        map.put("Apa", "Apa");
        map.put("Buruku", "Buruku");
        map.put("Gboko", "Gboko");
        map.put("Guma", "Guma");
        map.put("Gwer East", "Gwer East");
        map.put("Gwer West", "Gwer West");
        map.put("Katsina-Ala", "Katsina-Ala");
        map.put("Konshisha", "Konshisha");
        map.put("Kwande", "Kwande");
        map.put("Logo", "Logo");
        map.put("Makurdi", "Makurdi");
        map.put("Obi", "Obi");
        map.put("Ogbadibo", "Ogbadibo");
        map.put("Oju", "Oju");
        map.put("Okpokwu", "Okpokwu");
        map.put("Ohimini", "Ohimini");
        map.put("Oturkpo", "Oturkpo");
        map.put("Tarka", "Tarka");
        map.put("Ukum", "Ukum");
        map.put("Ushongo", "Ushongo");
        map.put("Vandeikya", "Vandeikya");
        data.put("BENUE", map);

        //LGAs under BORNU State
        map = new HashMap<String, String>();
        map.put("Abadam", "Abadam");
        map.put("Askira/Uba", "Askira/Uba");
        map.put("Bama", "Bama");
        map.put("Bayo", "Bayo");
        map.put("Biu", "Biu");
        map.put("Chibok", "Chibok");
        map.put("Damboa", "Damboa");
        map.put("Dikwa", "Dikwa");
        map.put("Gubio", "Gubio");
        map.put("Guzamala", "Guzamala");
        map.put("Gwoza", "Gwoza");
        map.put("Hawul", "Hawul");
        map.put("Jere", "Jere");
        map.put("Kaga", "Kaga");
        map.put("Kala/Balge", "Kala/Balge");
        map.put("Konduga", "Konduga");
        map.put("Kukawa", "Kukawa");
        map.put("Kwaya Kusar", "Kwaya Kusar");
        map.put("Mafa", "Mafa");
        map.put("Magumeri", "Magumeri");
        map.put("Maiduguri", "Maiduguri");
        map.put("Marte", "Marte");
        map.put("Mobbar", "Mobbar");
        map.put("Monguno", "Monguno");
        map.put("Ngala", "Ngala");
        map.put("Nganzai", "Nganzai");
        map.put("Shani", "Shani");
        data.put("BORNU", map);

        //LGAs under CROSS RIVER State
        map = new HashMap<String, String>();
        map.put("Akpabuyo", "Akpabuyo");
        map.put("Odukpani", "Odukpani");
        map.put("Akamkpa", "Akamkpa");
        map.put("Biase", "Biase");
        map.put("Abi", "Abi");
        map.put("Ikom", "Ikom");
        map.put("Yarkur", "Yarkur");
        map.put("Odubra", "Odubra");
        map.put("Boki", "Boki");
        map.put("Ogoja", "Ogoja");
        map.put("Yala", "Yala");
        map.put("Obanliku", "Obanliku");
        map.put("Obudu", "Obudu");
        map.put("Calabar South", "Calabar South");
        map.put("Etung", "Etung");
        map.put("Bekwara", "Bekwara");
        map.put("Bakassi", "Bakassi");
        map.put("Calabar Municipality", "Calabar Municipality");
        data.put("CROSS RIVER", map);

        //LGAs under DELTA State
        map = new HashMap<String, String>();
        map.put("Oshimili", "Oshimili");
        map.put("Aniocha", "Aniocha");
        map.put("Aniocha South", "Aniocha South");
        map.put("Ika South", "Ika South");
        map.put("Ika North-East", "Ika North-East");
        map.put("Ndokwa West", "Ndokwa West");
        map.put("Ndokwa East", "Ndokwa East");
        map.put("Isoko south", "Isoko south");
        map.put("Isoko North ", "Isoko North ");
        map.put("Bomadi", "Bomadi");
        map.put("Burutu", "Burutu");
        map.put("Ughelli South", "Ughelli South");
        map.put("Ughelli North", "Ughelli North");
        map.put("Ethiope West", "Ethiope West");
        map.put("Ethiope East", "Ethiope East");
        map.put("Sapele", "Sapele");
        map.put("Okpe", "Okpe");
        map.put("Warri North", "Warri North");
        map.put("Warri South", "Warri South");
        map.put("Uvwie", "Uvwie");
        map.put("Udu", "Udu");
        map.put("Warri Central", "Warri Central");
        map.put("Ukwani", "Ukwani");
        map.put("Oshimili North", "Oshimili North");
        map.put("Patani", "Patani");
        data.put("DELTA", map);

        //LGAs under EBONYI State
        map = new HashMap<String, String>();
        map.put("Afikpo South", "Afikpo South");
        map.put("Afikpo North", "Afikpo North");
        map.put("Onicha", "Onicha");
        map.put("Ohaozara", "Ohaozara");
        map.put("Abakaliki", "Abakaliki");
        map.put("Ishielu", "Ishielu");
        map.put("lkwo", "lkwo");
        map.put("Ezza", "Ezza");
        map.put("Ezza South", "Ezza South");
        map.put("Ohaukwu", "Ohaukwu");
        map.put("Ebonyi", "Ebonyi");
        map.put("Ivo", "Ivo");
        data.put("EBONYI", map);

        //LGAs under EDO State
        map = new HashMap<String, String>();
        map.put("Esan North-East", "Esan North-East");
        map.put("Esan Central", "Esan Central");
        map.put("Esan West", "Esan West");
        map.put("Egor", "Egor");
        map.put("Ukpoba", "Ukpoba");
        map.put("Central", "Central");
        map.put("Etsako Central", "Etsako Central");
        map.put("Igueben", "Igueben");
        map.put("Oredo", "Oredo");
        map.put("Ovia SouthWest", "Ovia SouthWest");
        map.put("Ovia South-East", "Ovia South-East");
        map.put("Orhionwon", "Orhionwon");
        map.put("Uhunmwonde", "Uhunmwonde");
        map.put("Etsako East", "Etsako East");
        map.put("Esan South-East", "Esan South-East");
        map.put("Egor", "Egor");
        data.put("EDO", map);

        //LGAs under EKITI State
        map = new HashMap<String, String>();
        map.put("Ado", "Ado");
        map.put("Ekiti-East", "Ekiti-East");
        map.put("Ekiti-West ", "Ekiti-West ");
        map.put("Emure/Ise/Orun", "Emure/Ise/Orun");
        map.put("Ekiti South-West", "Ekiti South-West");
        map.put("Ikare", "Ikare");
        map.put("Irepodun", "Irepodun");
        map.put("Ijero", "Ijero");
        map.put("Ido/Osi", "Ido/Osi");
        map.put("Oye", "Oye");
        map.put("Ikole", "Ikole");
        map.put("Moba", "Moba");
        map.put("Gbonyin", "Gbonyin");
        map.put("Efon", "Efon");
        map.put("Ise/Orun", "Ise/Orun");
        map.put("Ilejemeje", "Ilejemeje");
        data.put("EKITI", map);

        //LGAs under ENUGU State
        map = new HashMap<String, String>();
        map.put("Enugu South ", "Enugu South ");
        map.put("Igbo-Eze South", "Igbo-Eze South");
        map.put("Enugu North", "Enugu North");
        map.put("Udi Agwu", "Udi Agwu");
        map.put("Oji-River", "Oji-River");
        map.put("Ezeagu", "Ezeagu");
        map.put("IgboEze North", "IgboEze North");
        map.put("Isi-Uzo", "Isi-Uzo");
        map.put("Nsukka", "Nsukka");
        map.put("Igbo-Ekiti", "Igbo-Ekiti");
        map.put("Uzo-Uwani", "Uzo-Uwani");
        map.put("Enugu Eas", "Enugu Eas");
        map.put("Aninri", "Aninri");
        map.put("Nkanu East", "Nkanu East");
        map.put("Udenu", "Udenu");
        map.put("Nkanu", "Nkanu");
        data.put("ENUGU", map);

        //LGAs under GOMBE State
        map = new HashMap<String, String>();
        map.put("Akko", "Akko");
        map.put("Balanga", "Balanga");
        map.put("Billiri", "Billiri");
        map.put("Dukku", "Dukku");
        map.put("Kaltungo", "Kaltungo");
        map.put("Kwami", "Kwami");
        map.put("Shomgom", "Shomgom");
        map.put("Funakaye", "Funakaye");
        map.put("Gombe", "Gombe");
        map.put("Nafada/Bajoga ", "Nafada/Bajoga ");
        map.put("Yamaltu/Delta", "Yamaltu/Delta");
        data.put("GOMBE", map);

        //LGAs under IMO State
        map = new HashMap<String, String>();
        map.put("Aboh-Mbaise ", "Aboh-Mbaise ");
        map.put("Ahiazu-Mbaise", "Ahiazu-Mbaise");
        map.put("Ehime-Mbano", "Ehime-Mbano");
        map.put("Ezinihitte", "Ezinihitte");
        map.put("Ideato North", "Ideato North");
        map.put("Ideato South", "Ideato South");
        map.put("Ihitte/Uboma", "Ihitte/Uboma");
        map.put("Ikeduru", "Ikeduru");
        map.put("Isiala Mbano", "Isiala Mbano");
        map.put("Isu", "Isu");
        map.put("Mbaitoli", "Mbaitoli");
        map.put("Ngor-Okpala", "Ngor-Okpala");
        map.put("Njaba", "Njaba");
        map.put("Nwangele", "Nwangele");
        map.put("Nkwerre", "Nkwerre");
        map.put("Obowo", "Obowo");
        map.put("Oguta", "Oguta");
        map.put("Ohaji/Egbema", "Ohaji/Egbema");
        map.put("Okigwe", "Okigwe");
        map.put("Orlu", "Orlu");
        map.put("Orsu", "Orsu");
        map.put("Oru East", "Oru East");
        map.put("Oru West", "Oru West");
        map.put("Owerri-Municipal", "Owerri-Municipal");
        map.put("Owerri North", "Owerri North");
        map.put("Owerri West", "Owerri West");
        data.put("IMO", map);

        //LGAs under JIGAWA State
        map = new HashMap<String, String>();
        map.put("Auyo", "Auyo");
        map.put("Babura", "Babura");
        map.put("Birni Kudu", "Birni Kudu");
        map.put("Biriniwa", "Biriniwa");
        map.put("Buji", "Buji");
        map.put("Dutse", "Dutse");
        map.put("Gagarawa", "Gagarawa");
        map.put("Garki", "Garki");
        map.put("Gumel", "Gumel");
        map.put("Guri", "Guri");
        map.put("Gwaram", "Gwaram");
        map.put("Gwiwa", "Gwiwa");
        map.put("Hadejia", "Hadejia");
        map.put("Jahun", "Jahun");
        map.put("Kafin Hausa", "Kafin Hausa");
        map.put("Kaugama Kazaure", "Kaugama Kazaure");
        map.put("Kiri Kasamma", "Kiri Kasamma");
        map.put("Kiyawa", "Kiyawa");
        map.put("Maigatari", "Maigatari");
        map.put("Malam Madori", "Malam Madori");
        map.put("Miga", "Miga");
        map.put("Ringim", "Ringim");
        map.put("Roni", "Roni");
        map.put("Sule-Tankarkar", "Sule-Tankarkar");
        map.put("Taura", "Taura");
        map.put("Yankwashi", "Yankwashi");
        data.put("JIGAWA", map);

        //LGAs under KATSINA State
        map = new HashMap<String, String>();
        map.put("Bakori", "Bakori");
        map.put("Batagarawa", "Batagarawa");
        map.put("Batsari", "Batsari");
        map.put("Baure", "Baure");
        map.put("Bindawa", "Bindawa");
        map.put("Charanchi", "Charanchi");
        map.put("Dandume", "Dandume");
        map.put("Danja", "Danja");
        map.put("Dan Musa", "Dan Musa");
        map.put("Daura", "Daura");
        map.put("Dutsi", "Dutsi");
        map.put("Dutsin-Ma", "Dutsin-Ma");
        map.put("Faskari", "Faskari");
        map.put("Funtua", "Funtua");
        map.put("Ingawa", "Ingawa");
        map.put("Jibia", "Jibia");
        map.put("Kafur", "Kafur");
        map.put("Kaita", "Kaita");
        map.put("Kankara", "Kankara");
        map.put("Kankia", "Kankia");
        map.put("Katsina", "Katsina");
        map.put("Kurfi", "Kurfi");
        map.put("Kusada", "Kusada");
        map.put("Mai'Adua", "Mai'Adua");
        map.put("Malumfashi", "Malumfashi");
        map.put("Mani", "Mani");
        map.put("Mashi", "Mashi");
        map.put("Matazuu", "Matazuu");
        map.put("Musawa", "Musawa");
        map.put("Rimi", "Rimi");
        map.put("Sabuwa", "Sabuwa");
        map.put("Safana", "Safana");
        map.put("Sandamu", "Sandamu");
        map.put("Zango", "Zango");
        data.put("KATSINA", map);

        //LGAs under KEBBI State
        map = new HashMap<String, String>();
        map.put("Aleiro", "Aleiro");
        map.put("Arewa-Dandi", "Arewa-Dandi");
        map.put("Argungu", "Argungu");
        map.put("Augie", "Augie");
        map.put("Bagudo", "Bagudo");
        map.put("Birnin Kebbi", "Birnin Kebbi");
        map.put("Bunza", "Bunza");
        map.put("Dandi", "Dandi");
        map.put("Fakai", "Fakai");
        map.put("Gwandu", "Gwandu");
        map.put("Jega", "Jega");
        map.put("Kalgo", "Kalgo");
        map.put("Koko/Besse", "Koko/Besse");
        map.put("Maiyama", "Maiyama");
        map.put("Ngaski", "Ngaski");
        map.put("Sakaba", "Sakaba");
        map.put("Shanga", "Shanga");
        map.put("Suru", "Suru");
        map.put("Wasagu/Danko", "Wasagu/Danko");
        map.put("Yauri", "Yauri");
        map.put("Zuru", "Zuru");
        data.put("KEBBI", map);

        //LGAs under KOGI State
        map = new HashMap<String, String>();
        map.put("Adavi", "Adavi");
        map.put("Ajaokuta", "Ajaokuta");
        map.put("Ankpa", "Ankpa");
        map.put("Bassa", "Bassa");
        map.put("Dekina", "Dekina");
        map.put("Ibaji", "Ibaji");
        map.put("Idah", "Idah");
        map.put("Igalamela-Odolu ", "Igalamela-Odolu ");
        map.put("Ijumu", "Ijumu");
        map.put("Kabba/Bunu", "Kabba/Bunu");
        map.put("Kogi", "Kogi");
        map.put("Lokoja", "Lokoja");
        map.put("Mopa-Muro", "Mopa-Muro");
        map.put("Ofu", "Ofu");
        map.put("Ogori/Mangongo", "Ogori/Mangongo");
        map.put("Okehi", "Okehi");
        map.put("Okene", "Okene");
        map.put("Olamabolo", "Olamabolo");
        map.put("Omala", "Omala");
        map.put("Yagba East", "Yagba East");
        map.put("Yagba West", "Yagba West");
        data.put("KOGI", map);

        //LGAs under KWARA State
        map = new HashMap<String, String>();
        map.put("Asa", "Asa");
        map.put("Baruten", "Baruten");
        map.put("Edu", "Edu");
        map.put("Ekiti", "Ekiti");
        map.put("Ifelodun", "Ifelodun");
        map.put("Ilorin East", "Ilorin East");
        map.put("Ilorin West", "Ilorin West");
        map.put("Irepodun", "Irepodun");
        map.put("Isin", "Isin");
        map.put("Kaiama", "Kaiama");
        map.put("Moro", "Moro");
        map.put("Offa", "Offa");
        map.put("Oke-Ero", "Oke-Ero");
        map.put("Oyun", "Oyun");
        map.put("Pategi", "Pategi");
        data.put("KWARA", map);

        //LGAs under LAGOS State
        map = new HashMap<String, String>();
        map.put("Agege", "Agege");
        map.put("Ajeromi-Ifelodun", "Ajeromi-Ifelodun");
        map.put("Alimosho", "Alimosho");
        map.put("Amuwo-Odofin", "Amuwo-Odofin");
        map.put("Apapa", "Apapa");
        map.put("Badagry", "Badagry");
        map.put("Epe", "Epe");
        map.put("Eti-Osa", "Eti-Osa");
        map.put("Ibeju/Lekki", "Ibeju/Lekki");
        map.put("Ifako-Ijaye", "Ifako-Ijaye");
        map.put("Ikeja", "Ikeja");
        map.put("Ikorodu", "Ikorodu");
        map.put("Kosofe", "Kosofe");
        map.put("Lagos Island", "Lagos Island");
        map.put("Lagos Mainland", "Lagos Mainland");
        map.put("Mushin", "Mushin");
        map.put("Ojo", "Ojo");
        map.put("Oshodi-Isolo", "Oshodi-Isolo");
        map.put("Shomolu", "Shomolu");
        map.put("Surulere", "Surulere");
        data.put("LAGOS", map);

        //LGAs under NASARAWA State
        map = new HashMap<String, String>();
        map.put("Akwanga", "Akwanga");
        map.put("Awe", "Awe");
        map.put("Doma", "Doma");
        map.put("Karu", "Karu");
        map.put("Keana", "Keana");
        map.put("Keffi", "Keffi");
        map.put("Kokona", "Kokona");
        map.put("Lafia", "Lafia");
        map.put("Nasarawa", "Nasarawa");
        map.put("Nasarawa-Eggon", "Nasarawa-Eggon");
        map.put("Obi", "Obi");
        map.put("Toto", "Toto");
        map.put("Wamba", "Wamba");
        data.put("NASARAWA", map);

//LGAs under NIGER State
        map = new HashMap<String, String>();
        map.put("Agaie", "Agaie");
        map.put("Agwara", "Agwara");
        map.put("Bida", "Bida");
        map.put("Borgu", "Borgu");
        map.put("Bosso", "Bosso");
        map.put("Chanchaga", "Chanchaga");
        map.put("Edati", "Edati");
        map.put("Gbako", "Gbako");
        map.put("Gurara", "Gurara");
        map.put("Katcha", "Katcha");
        map.put("Kontagora", "Kontagora");
        map.put("Lapai", "Lapai");
        map.put("Lavun", "Lavun");
        map.put("Magama", "Magama");
        map.put("Mariga", "Mariga");
        map.put("Mashegu", "Mashegu");
        map.put("Mokwa", "Mokwa");
        map.put("Muya", "Muya");
        map.put("Pailoro", "Pailoro");
        map.put("Rafi", "Rafi");
        map.put("Rijau", "Rijau");
        map.put("Shiroro", "Shiroro");
        map.put("Suleja", "Suleja");
        map.put("Tafa", "Tafa");
        map.put("Wushishi", "Wushishi");
        data.put("NIGER", map);

        //LGAs under OGUN State
        map = new HashMap<String, String>();
        map.put("Abeokuta North", "Abeokuta North");
        map.put("Abeokuta South", "Abeokuta South");
        map.put("Ado-Odo/Ota", "Ado-Odo/Ota");
        map.put("Egbado North", "Egbado North");
        map.put("Egbado South", "Egbado South");
        map.put("Ewekoro", "Ewekoro");
        map.put("Ifo", "Ifo");
        map.put("Ijebu East", "Ijebu East");
        map.put("Ijebu North", "Ijebu North");
        map.put("Ijebu North East", "Ijebu North East");
        map.put("Ijebu Ode", "Ijebu Ode");
        map.put("Ikenne", "Ikenne");
        map.put("Imeko-Afon", "Imeko-Afon");
        map.put("Ipokia", "Ipokia");
        map.put("Obafemi-Owode", "Obafemi-Owode");
        map.put("Ogun Waterside", "Ogun Waterside");
        map.put("Odeda", "Odeda");
        map.put("Odogbolu", "Odogbolu");
        map.put("Remo North", "Remo North");
        map.put("Shagamu", "Shagamu");
        data.put("OGUN", map);

        //LGAs under ONDO State
        map = new HashMap<String, String>();
        map.put("Akoko North East", "Akoko North East");
        map.put("Akoko North West", "Akoko North West");
        map.put("Akoko South Akure East", "Akoko South Akure East");
        map.put("Akoko South West", "Akoko South West");
        map.put("Akure North", "Akure North");
        map.put("Akure South", "Akure South");
        map.put("Ese-Odo", "Ese-Odo");
        map.put("Idanre", "Idanre");
        map.put("Ifedore", "Ifedore");
        map.put("Ifedore", "Ifedore");
        map.put("Ilaje", "Ilaje");
        map.put("Ile-Oluji", "Ile-Oluji");
        map.put("Okeigbo", "Okeigbo");
        map.put("Irele", "Irele");
        map.put("Odigbo", "Odigbo");
        map.put("Okitipupa", "Okitipupa");
        map.put("Ondo East", "Ondo East");
        map.put("Ose", "Ose");
        map.put("Owo", "Owo");
        data.put("ONDO", map);

        //LGAs under OSUN State
        map = new HashMap<String, String>();
        map.put("Aiyedade", "Aiyedade");
        map.put("Aiyedire", "Aiyedire");
        map.put("Atakumosa East", "Atakumosa East");
        map.put("Atakumosa West", "Atakumosa West");
        map.put("Boluwaduro", "Boluwaduro");
        map.put("Boripe", "Boripe");
        map.put("Ede North", "Ede North");
        map.put("Ede South", "Ede South");
        map.put("Egbedore", "Egbedore");
        map.put("Ejigbo", "Ejigbo");
        map.put("Ife Central", "Ife Central");
        map.put("Ife East", "Ife East");
        map.put("Ife North", "Ife North");
        map.put("Ife South", "Ife South");
        map.put("Ifedayo", "Ifedayo");
        map.put("Ifelodun", "Ifelodun");
        map.put("Ila", "Ila");
        map.put("Ilesha East", "Ilesha East");
        map.put("Ilesha West", "Ilesha West");
        map.put("Irepodun", "Irepodun");
        map.put("Irewole", "Irewole");
        map.put("Isokan", "Isokan");
        map.put("Iwo", "Iwo");
        map.put("Obokun", "Obokun");
        map.put("Odo-Otin", "Odo-Otin");
        map.put("Ola-Oluwa", "Ola-Oluwa");
        map.put("Olorunda", "Olorunda");
        map.put("Oriade", "Oriade");
        map.put("Orolu", "Orolu");
        map.put("Osogbo", "Osogbo");
        data.put("OSUN", map);

        //LGAs under OYO State
        map = new HashMap<String, String>();
        map.put("Afijio", "Afijio");
        map.put("Akinyele", "Akinyele");
        map.put("Atiba", "Atiba");
        map.put("Atigbo", "Atigbo");
        map.put("Egbeda", "Egbeda");
        map.put("IbadanCentral", "IbadanCentral");
        map.put("Ibadan North", "Ibadan North");
        map.put("Ibadan North West", "Ibadan North West");
        map.put("Ibadan South East", "Ibadan South East");
        map.put("Ibadan South West", "Ibadan South West");
        map.put("Ibarapa Central", "Ibarapa Central");
        map.put("Ibarapa East", "Ibarapa East");
        map.put("Ibarapa North", "Ibarapa North");
        map.put("Ido", "Ido");
        map.put("Irepo", "Irepo");
        map.put("Iseyin", "Iseyin");
        map.put("Itesiwaju", "Itesiwaju");
        map.put("Iwajowa", "Iwajowa");
        map.put("Kajola", "Kajola");
        map.put("Lagelu Ogbomosho North", "Lagelu Ogbomosho North");
        map.put("Ogbmosho South", "Ogbmosho South");
        map.put("Ogo Oluwa", "Ogo Oluwa");
        map.put("Olorunsogo", "Olorunsogo");
        map.put("Oluyole", "Oluyole");
        map.put("Ona-Ara ", "Ona-Ara ");
        map.put("Ori Ire", "Orelope");
        map.put("Ori Ire", "Ori Ire");
        map.put("Oyo East", "Oyo East");
        map.put("Oyo West", "Oyo West");
        map.put("Saki East", "Saki East");
        map.put("Saki West", "Saki West");
        map.put("Surulere", "Surulere");
        data.put("OYO", map);

//LGAs under PLATEAU State
        map = new HashMap<String, String>();
        map.put("Barikin Ladi", "Barikin Ladi");
        map.put("Bassa", "Bassa");
        map.put("Bokkos", "Bokkos");
        map.put("Jos East", "Jos East");
        map.put("Jos North", "Jos North");
        map.put("Jos South", "Jos South");
        map.put("Kanam", "Kanam");
        map.put("Kanke", "Kanke");
        map.put("Langtang North", "Langtang North");
        map.put("Langtang South", "Langtang South");
        map.put("Mangu", "Mangu");
        map.put("Mikang", "Mikang");
        map.put("Pankshin", "Pankshin");
        map.put("Qua'an Pan", "Qua'an Pan");
        map.put("Riyom", "Riyom");
        map.put("Shendam", "Shendam");
        map.put("Wase", "Wase");
        data.put("PLATEAU", map);

        //LGAs under RIVERS State
        map = new HashMap<String, String>();
        map.put("Abua/Odual", "Abua/Odual");
        map.put("Ahoada East", "Ahoada East");
        map.put("Ahoada West", "Ahoada West");
        map.put("Akuku Toru", "Akuku Toru");
        map.put("Andoni", "Andoni");
        map.put("Asari-Toru", "Asari-Toru");
        map.put("Bonny ", "Bonny");
        map.put("Degema", "Degema");
        map.put("Emohua", "Emohua");
        map.put("Eleme", "Eleme");
        map.put("Etche", "Etche");
        map.put("Gokana", "Gokana");
        map.put("Ikwerre", "Ikwerre");
        map.put("Khana", "Khana");
        map.put("Obia/Akpor", "Obia/Akpor");
        map.put("Ogba/Egbema/Ndoni", "Ogba/Egbema/Ndoni");
        map.put("Ogu/Bolo", "Ogu/Bolo");
        map.put("Okrika", "Okrika");
        map.put("Omumma", "Omumma");
        map.put("Opobo/Nkoro", "Opobo/Nkoro");
        map.put("Oyigbo", "Oyigbo");
        map.put("Port-Harcourt", "Port-Harcourt");
        map.put("Tai", "Tai");
        data.put("RIVERS", map);

        //LGAs under SOKOTO State
        map = new HashMap<String, String>();
        map.put("Binji", "Binji");
        map.put("Bodinga", "Bodinga");
        map.put("Dange-shnsi", "Dange-shnsi");
        map.put("Gada", "Gada");
        map.put("Goronyo", "Goronyo");
        map.put("Gudu", "Gudu");
        map.put("Gawabawa", "Gawabawa");
        map.put("Illela", "Illela");
        map.put("Isa", "Isa");
        map.put("Kware", "Kware");
        map.put("kebbe", "kebbe");
        map.put("Rabah", "Rabah");
        map.put("Sabon birni", "Sabon birni");
        map.put("Shagari", "Shagari");
        map.put("Silame", "Silame");
        map.put("Sokoto North", "Sokoto North");
        map.put("Sokoto South", "Sokoto South");
        map.put("Tambuwal", "Tambuwal");
        map.put("Tqngaza", "Tqngaza");
        map.put("Tureta", "Tureta");
        map.put("Wamako", "Wamako");
        map.put("Wurno", "Wurno");
        map.put("Yabo", "Yabo");
        data.put("SOKOTO", map);

        //LGAs under TARABA State
        map = new HashMap<String, String>();
        map.put("Ardo-kola ", "Ardo-kola ");
        map.put("Bali", "Bali");
        map.put("Donga", "Donga");
        map.put("Gashaka", "Gashaka");
        map.put("Cassol", "Cassol");
        map.put("Ibi", "Ibi");
        map.put("Jalingo", "Jalingo");
        map.put("Karin-Lamido", "Karin-Lamido");
        map.put("Kurmi", "Kurmi");
        map.put("Lau", "Lau");
        map.put("Sardauna", "Sardauna");
        map.put("Takum", "Takum");
        map.put("Ussa", "Ussa");
        map.put("Wukari", "Wukari");
        map.put("Yorro", "Yorro");
        map.put("Zing", "Zing");
        data.put("TARABA", map);

        //LGAs under YOBE State
        map = new HashMap<String, String>();
        map.put("Bade", "Bade");
        map.put("Bursari", "Bursari");
        map.put("Damaturu", "Damaturu");
        map.put("Fika", "Fika");
        map.put("Fune", "Fune");
        map.put("Geidam", "Geidam");
        map.put("Gujba", "Gujba");
        map.put("Gulani", "Gulani");
        map.put("Jakusko", "Jakusko");
        map.put("Karasuwa", "Karasuwa");
        map.put("Karawa", "Karawa");
        map.put("Machina", "Machina");
        map.put("Nangere", "Nangere");
        map.put("Nguru Potiskum", "Nguru Potiskum");
        map.put("Tarmua", "Tarmua");
        map.put("Yunusari", "Yunusari");
        map.put("Yusufari", "Yusufari");
        data.put("YOBE", map);

        //LGAs under ZAMFARA State
        map = new HashMap<String, String>();
        map.put("Anka", "Anka");
        map.put("Bakura", "Bakura");
        map.put("Birnin Magaji", "Birnin Magaji");
        map.put("Bukkuyum", "Bukkuyum");
        map.put("Bungudu", "Bungudu");
        map.put("Gummi", "Gummi");
        map.put("Gusau", "Gusau");
        map.put("Kaura", "Kaura");
        map.put("Namoda", "Namoda");
        map.put("Maradun", "Maradun");
        map.put("Maru", "Maru");
        map.put("Shinkafi", "Shinkafi");
        map.put("Talata Mafara", "Talata Mafara");
        map.put("Tsafe", "Tsafe");
        map.put("Zurmi", "Zurmi");
        data.put("ZAMFARA", map);

        System.out.println("Printing state from Bean:" + state);
        System.out.println("Printing LGA from Bean:" + lga);

    }//end-of init method

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public Map<String, String> getStates() {
        return states;
    }

    public Map<String, String> getLgas() {
        return lgas;
    }

    public void onStateChange() {
        if (state != null && !state.equals("")) {
            lgas = data.get(state);
        } else {
            lgas = new HashMap<String, String>();
        }
    }

    ////////////////////////
}//end of class
