import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandCategorizationSwing extends JFrame {

    private JPanel mainPanel, agriculturalPanel, commercialPanel;
    private JButton calculateButton;
    private JTextArea resultArea;

    public LandCategorizationSwing() {
        setTitle("Land Categorization");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));
        JLabel titleLabel = new JLabel("Select Area Type:", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel);

        JButton agriculturalButton = new JButton("Agricultural Area");
        JButton commercialButton = new JButton("Commercial and Residential Area");
        mainPanel.add(agriculturalButton);
        mainPanel.add(commercialButton);

        agriculturalButton.addActionListener(e -> showAgriculturalPanel());
        commercialButton.addActionListener(e -> showCommercialPanel());

        add(mainPanel, "Main");

        // Agricultural Panel
        agriculturalPanel = new JPanel();
        agriculturalPanel.setLayout(new GridLayout(7, 2));
        agriculturalPanel.add(new JLabel("Irrigation Facility:"));
        String[] irrigationOptions = {"Continuous irrigation facility", "Partial irrigation facility", "Depending on the rainfall", "Dry"};
        JComboBox<String> irrigationCombo = new JComboBox<>(irrigationOptions);
        agriculturalPanel.add(irrigationCombo);

        agriculturalPanel.add(new JLabel("Road Facility:"));
        String[] roadOptions = {"Main Road", "Gravel Road", "Horse Road", "Trial Road", "Without Road facility"};
        JComboBox<String> roadCombo = new JComboBox<>(roadOptions);
        agriculturalPanel.add(roadCombo);

        agriculturalPanel.add(new JLabel("Crop Farming:"));
        String[] cropOptions = {"More than one crop to be farmed", "Only one crop to be farmed"};
        JComboBox<String> cropCombo = new JComboBox<>(cropOptions);
        agriculturalPanel.add(cropCombo);

        agriculturalPanel.add(new JLabel("Types of Soil:"));
        String[] soilOptions = {"Good Fertile", "Mixed (Dumat)", "Marcy Land (Dhap)", "Sandy (Balaute)", "Graveled (Dhungyan)"};
        JComboBox<String> soilCombo = new JComboBox<>(soilOptions);
        agriculturalPanel.add(soilCombo);

        agriculturalPanel.add(new JLabel("Altitude of Land from the sea level:"));
        String[] altitudeOptions = {"Upto 500 meter", "More than 500 meter upto 1000 meter", "More than 1000 meter upto 2000 meter", "More than 2000 meter upto 3000 meter", "More than 3000 meter"};
        JComboBox<String> altitudeCombo = new JComboBox<>(altitudeOptions);
        agriculturalPanel.add(altitudeCombo);

        agriculturalPanel.add(new JLabel("Agriculture Market Facility:"));
        String[] marketOptions = {"Upto 5 km.", "More than 5 km. upto 10 km.", "More than that"};
        JComboBox<String> marketCombo = new JComboBox<>(marketOptions);
        agriculturalPanel.add(marketCombo);

        agriculturalPanel.add(new JLabel("Elevation of Land:"));
        String[] elevationOptions = {"Plain (Samatal)", "Terrain Terrace (Tari Garha)", "Slope without terrace (Garha)", "Slope (Bhiralo)"};
        JComboBox<String> elevationCombo = new JComboBox<>(elevationOptions);
        agriculturalPanel.add(elevationCombo);

        calculateButton = new JButton("Calculate");
        agriculturalPanel.add(calculateButton);
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        agriculturalPanel.add(new JScrollPane(resultArea));

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalMarks = 0;
                totalMarks += getAgricultureMarks(irrigationCombo.getSelectedIndex(), roadCombo.getSelectedIndex(), cropCombo.getSelectedIndex(), soilCombo.getSelectedIndex(), altitudeCombo.getSelectedIndex(), marketCombo.getSelectedIndex(), elevationCombo.getSelectedIndex());
                resultArea.setText("Total Marks: " + totalMarks + "\nGrade: " + getAgriculturalGrade(totalMarks));
            }
        });

        add(agriculturalPanel, "Agricultural");

        // Commercial Panel
        commercialPanel = new JPanel();
        commercialPanel.setLayout(new GridLayout(9, 2));
        commercialPanel.add(new JLabel("Road Facility:"));
        String[] commercialRoadOptions = {"Main Road", "Sub Road", "Branch Road", "Development Road", "Street Pass", "Trial Road", "Without Road Facility"};
        JComboBox<String> commercialRoadCombo = new JComboBox<>(commercialRoadOptions);
        commercialPanel.add(commercialRoadCombo);

        commercialPanel.add(new JLabel("Water Facility:"));
        String[] waterOptions = {"Personal Tap Facility", "Public Tap Facility", "Natural Resource"};
        JComboBox<String> waterCombo = new JComboBox<>(waterOptions);
        commercialPanel.add(waterCombo);

        commercialPanel.add(new JLabel("Electricity Facility:"));
        String[] electricityOptions = {"Continuous service", "Partial Facility", "Without Electricity Facility"};
        JComboBox<String> electricityCombo = new JComboBox<>(electricityOptions);
        commercialPanel.add(electricityCombo);

        commercialPanel.add(new JLabel("Location of the land:"));
        String[] locationOptions = {"Health", "Education", "Commercial", "Administrative"};
        JComboBox<String> locationCombo = new JComboBox<>(locationOptions);
        commercialPanel.add(locationCombo);

        commercialPanel.add(new JLabel("Transport Facility:"));
        String[] transportOptions = {"Having Public Transport Facility", "Having Partial Facility", "Without Facility"};
        JComboBox<String> transportCombo = new JComboBox<>(transportOptions);
        commercialPanel.add(transportCombo);

        commercialPanel.add(new JLabel("Communication Facility:"));
        String[] communicationOptions = {"Having Telephone Facility", "Without Telephone Facility"};
        JComboBox<String> communicationCombo = new JComboBox<>(communicationOptions);
        commercialPanel.add(communicationCombo);

        commercialPanel.add(new JLabel("Facility for Sewerage:"));
        String[] sewerageOptions = {"Public Sewerage", "Without PSF"};
        JComboBox<String> sewerageCombo = new JComboBox<>(sewerageOptions);
        commercialPanel.add(sewerageCombo);

        commercialPanel.add(new JLabel("Nature of Temporary Residence:"));
        String[] residenceOptions = {"Full time (Whole Time)", "Short time"};
        JComboBox<String> residenceCombo = new JComboBox<>(residenceOptions);
        commercialPanel.add(residenceCombo);

        calculateButton = new JButton("Calculate");
        commercialPanel.add(calculateButton);
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        commercialPanel.add(new JScrollPane(resultArea));

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalMarks = 0;
                totalMarks += getCommercialResidentialMarks(commercialRoadCombo.getSelectedIndex(), waterCombo.getSelectedIndex(), electricityCombo.getSelectedIndex(), locationCombo.getSelectedIndex(), transportCombo.getSelectedIndex(), communicationCombo.getSelectedIndex(), sewerageCombo.getSelectedIndex(), residenceCombo.getSelectedIndex());
                resultArea.setText("Total Marks: " + totalMarks + "\nGrade: " + getCommercialGrade(totalMarks));
            }
        });

        add(commercialPanel, "Commercial");

        setVisible(true);
    }

    private void showAgriculturalPanel() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "Agricultural");
    }

    private void showCommercialPanel() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "Commercial");
    }

    public static int getAgricultureMarks(int irrigationChoice, int roadChoice, int cropChoice, int soilChoice, int altitudeChoice, int marketChoice, int elevationChoice) {
        int marks = 0;
        marks += switch (irrigationChoice) {
            case 0 -> 10;
            case 1 -> 7;
            case 2 -> 3;
            case 3 -> 1;
            default -> 0;
        };
        marks += switch (roadChoice) {
            case 0 -> 8;
            case 1 -> 6;
            case 2 -> 4;
            case 3 -> 2;
            case 4 -> 1;
            default -> 0;
        };
        marks += switch (cropChoice) {
            case 0 -> 4;
            case 1 -> 2;
            default -> 0;
        };
        marks += switch (soilChoice) {
            case 0 -> 10;
            case 1 -> 8;
            case 2 -> 5;
            case 3 -> 3;
            case 4 -> 2;
            default -> 0;
        };
        marks += switch (altitudeChoice) {
            case 0 -> 6;
            case 1 -> 5;
            case 2 -> 4;
            case 3 -> 3;
            case 4 -> 1;
            default -> 0;
        };
        marks += switch (marketChoice) {
            case 0 -> 4;
            case 1 -> 2;
            case 2 -> 1;
            default -> 0;
        };
        marks += switch (elevationChoice) {
            case 0 -> 8;
            case 1 -> 5;
            case 2 -> 3;
            case 3 -> 1;
            default -> 0;
        };
        return marks;
    }

    public static int getCommercialResidentialMarks(int roadChoice, int waterChoice, int electricityChoice, int locationChoice, int transportChoice, int communicationChoice, int sewerageChoice, int residenceChoice) {
        int marks = 0;
        marks += switch (roadChoice) {
            case 0 -> 10;
            case 1 -> 8;
            case 2 -> 6;
            case 3 -> 4;
            case 4 -> 2;
            case 5 -> 1;
            case 6 -> 0;
            default -> 0;
        };
        marks += switch (waterChoice) {
            case 0 -> 10;
            case 1 -> 5;
            case 2 -> {
                System.out.println("    a. Upto 1 km.");
                System.out.println("    b. More than 1 km. upto 3 km.");
                System.out.println("    c. More than 3 km.");
                int subChoice = scanner.nextInt();
                marks += switch (subChoice) {
                    case 1 -> 10;
                    case 2 -> 1;
                    case 3 -> 0;
                    default -> 0;
                };
            }
            default -> 0;
        };
        marks += switch (electricityChoice) {
            case 0 -> {
                System.out.println("    a. Industrial");
                System.out.println("    b. Partial Industrial");
                int subChoice = scanner.nextInt();
                marks += switch (subChoice) {
                    case 1 -> 8;
                    case 2 -> 4;
                    default -> 0;
                };
            }
            case 1 -> 3;
            case 2 -> 0;
            default -> 0;
        };
        marks += switch (locationChoice) {
            case 0, 1, 2, 3 -> 2;
            default -> 0;
        };
        marks += switch (transportChoice) {
            case 0 -> 5;
            case 1 -> 2;
            case 2 -> 0;
            default -> 0;
        };
        marks += switch (communicationChoice) {
            case 0 -> 4;
            case 1 -> 0;
            default -> 0;
        };
        marks += switch (sewerageChoice) {
            case 0 -> 3;
            case 1 -> 0;
            default -> 0;
        };
        marks += switch (residenceChoice) {
            case 0 -> 2;
            case 1 -> 1;
            default -> 0;
        };
        return marks;
    }

    public static String getAgriculturalGrade(int marks) {
        if (marks >= 46) {
            return "1a Grade";
        } else if (marks >= 36) {
            return "1b Grade";
        } else if (marks >= 26) {
            return "1c Grade";
        } else if (marks >= 16) {
            return "1d Grade";
        } else if (marks >= 1) {
            return "1e Grade";
        } else {
            return "Ungraded";
        }
    }

    public static String getCommercialGrade(int marks) {
        if (marks >= 41) {
            return "2a Grade";
        } else if (marks >= 31) {
            return "2b Grade";
        } else if (marks >= 21) {
            return "2c Grade";
        } else if (marks >= 11) {
            return "2d Grade";
        } else if (marks >= 1) {
            return "2e Grade";
        } else {
            return "Ungraded";
        }
    }

    public static void main(String[] args) {
        new LandCategorizationSwing();
    }
}
