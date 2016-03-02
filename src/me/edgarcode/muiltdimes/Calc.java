package me.edgarcode.muiltdimes;

import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Calc {
    private String rootPath;
    private String folder;
    private boolean pre_is_dimen = false;

    public Calc(String folder) {
        rootPath = System.getProperty("user.dir");
        this.folder = folder;
    }

    private Element parseXML() {
        File f = new File(rootPath + "/dimens.xml");
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(f);
            Element root = doc.getRootElement();
            return root;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getFileName(String name) {
        String folderPath = rootPath + "/output/" + folder + "/" + name;
        File file = new File(folderPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return folderPath + "/dimens.xml";
    }

    public void createXML(String name, float scale, String comment) {
        System.out.println("createXML " + name);
        String fileName = getFileName(name);
        Element root = parseXML();
        if (root == null)
            return;
        Document document = DocumentHelper.createDocument();
        Element booksElement = document.addElement("resources");
        booksElement.addComment("this dimens for 1920x1080 160dpi");
        for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
            Element element = (Element) i.next();
            String value = element.getStringValue();
            String endpoint = value.substring(value.length() - 2, value.length());
            float dimen_value = Float.parseFloat(value.substring(0, value.length() - 2));
            dimen_value = dimen_value * scale;
            DecimalFormat decimalFormat = new DecimalFormat(".0");// 构造方法的字符格式这里如果小数不足1位,会以0补足.
            String dimen_value_str = decimalFormat.format(dimen_value);// format
                                                                       // 返回的是字符串
            Element newElement = booksElement.addElement("dimen");
            String attri = element.attributeValue("name");
            if (!pre_is_dimen)
                attri = attri.replace("dimen_", "dimens_");
            System.out.println("attribute = " + attri);
            newElement.addAttribute("name", attri);
            newElement.setText(dimen_value_str + endpoint);
        }
        try {
            /** 将document中的内容写入文件中 */
            OutputFormat xmlFormat = new OutputFormat();
            xmlFormat.setEncoding("UTF-8");
            // 设置换行
            xmlFormat.setNewlines(true);
            // 生成缩进
            xmlFormat.setIndent(true);
            XMLWriter writer = new XMLWriter(new FileWriter(new File(fileName)), xmlFormat);
            writer.write(document);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
